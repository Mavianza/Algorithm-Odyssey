import java.util.Scanner;

public class GameMap {
    private NodeRoom root;
    private final Scanner scanner;

    private class NodeRoom {
        String roomName;
        Components.NodeMonster monster;
        NodeRoom left;
        NodeRoom middle;  // Tambah middle child
        NodeRoom right;

        NodeRoom(String roomName, Components.NodeMonster monster) {
            this.roomName = roomName;
            this.monster = monster;
            this.left = null;
            this.middle = null;
            this.right = null;
        }
    }

    public GameMap(Scanner scanner) {
        this.scanner = scanner;
    }

    public void addRoot(String roomName, Components.NodeMonster monster) {
        root = new NodeRoom(roomName, monster);
    }

    public void addRoom(String parentRoom, String roomName, Components.NodeMonster monster, boolean isLeft) {
        NodeRoom parent = findRoom(root, parentRoom);
        if (parent != null) {
            NodeRoom newRoom = new NodeRoom(roomName, monster);
            if (isLeft) {
                parent.left = newRoom;
            } else {
                if (parent.middle == null) {
                    parent.middle = newRoom;
                } else {
                    parent.right = newRoom;
                }
            }
        }
    }

    private NodeRoom findRoom(NodeRoom current, String roomName) {
        if (current == null) return null;
        if (current.roomName.equals(roomName)) return current;

        NodeRoom foundRoom = findRoom(current.left, roomName);
        if (foundRoom == null) {
            foundRoom = findRoom(current.middle, roomName);
        }
        if (foundRoom == null) {
            foundRoom = findRoom(current.right, roomName);
        }
        return foundRoom;
    }

    public void explore(Components.NodePlayer player) {
        exploreRoom(root, player);
    }

    private void exploreRoom(NodeRoom current, Components.NodePlayer player) {
        if (current == null) return;

        if (current.monster != null) {
            System.out.println("You encountered a " + current.monster.namaMonster + "!");
            boolean isVictory = Battle.fight(player, current.monster, player.playerSkills, player.inventory);
            if (!isVictory) {
                System.out.println("Game Over! You were defeated.");
                return;
            }
            current.monster = null;
        }

        if (current.left == null && current.middle == null && current.right == null) {
            System.out.println("You've reached the end of this path.");
            return;
        }
        printMap();
        System.out.println("\nChoose your path:");
        if (current.left != null) {
            System.out.println("1. Go to " + current.left.roomName);
        }
        if (current.middle != null) {
            System.out.println("2. Go to " + current.middle.roomName);
        }
        if (current.right != null) {
            System.out.println("3. Go to " + current.right.roomName);
        }

        int choice = getValidInput();
        Battle.clearScreen();

        if (choice == 1 && current.left != null) {
            exploreRoom(current.left, player);
        } else if (choice == 2 && current.middle != null) {
            exploreRoom(current.middle, player);

            if (current.right != null) {
                System.out.println("Automatically moving to " + current.right.roomName + "...");
                player.healthPlayer -= 30;
                exploreRoom(current.right, player);
            }
        } else if (choice == 3 && current.right != null) {
            exploreRoom(current.right, player);
        } else {
            System.out.println("Invalid choice, please choose again.");
            exploreRoom(current, player);
        }
    }

    private int getValidInput() {
        while (true) {
            if (!scanner.hasNext()) {
                System.out.println("No input detected. Exiting game.");
                System.exit(0);
            }

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice >= 1 && choice <= 3) { 
                    return choice;
                } else {
                    System.out.println("Invalid choice. Please select 1, 2, or 3.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }
    }
    public void printMap() {
        System.out.println("╔═════════════════════════╗");
        System.out.println("║       Odyssey Map       ║");
        System.out.println("╚═════════════════════════╝");
        if (root != null) {
            System.out.println(root.roomName +
                (root.monster != null ? " [Monster: " + root.monster.namaMonster + "]" : ""));
            String indent = "";
            
            boolean hasLeft = root.left != null;
            boolean hasMiddle = root.middle != null;
            boolean hasRight = root.right != null;
            
            if (hasLeft) {
                printRoom(root.left, indent, !(hasMiddle || hasRight), 1);
            }
            if (hasMiddle) {
                printRoom(root.middle, indent, !hasRight, 1);
            }
            if (hasRight) {
                printRoom(root.right, indent, true, 1);
            }
        }
    }
    
    private void printRoom(NodeRoom current, String indent, boolean isLast, int level) {
        if (current == null) return;

        System.out.println(indent + (isLast ? "└── " : "├── ") + "[Level " + level + "] " + current.roomName +
            (current.monster != null ? " [Monster: " + current.monster.namaMonster + "]" : ""));

        indent += isLast ? "    " : "│   ";

        boolean hasLeft = current.left != null;
        boolean hasMiddle = current.middle != null;
        boolean hasRight = current.right != null;

        if (hasLeft) {
            printRoom(current.left, indent, !(hasMiddle || hasRight), level + 1);
        }
        if (hasMiddle) {
            printRoom(current.middle, indent, !hasRight, level + 1);
        }
        if (hasRight) {
            printRoom(current.right, indent, true, level + 1);
        }
    }   
}