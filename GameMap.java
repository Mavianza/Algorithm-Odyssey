import java.util.Scanner;
class GameMap {
    private NodeRoom root;
    private final Scanner scanner;

    public GameMap(Scanner scanner) {
        this.scanner = scanner;
    }

    // tambah root
    public void addRoot(String roomName, Components.NodeMonster monster) {
        root = new NodeRoom(roomName, monster);
    }

    // tambah room ke kiri sama kanan
    public void addRoom(String parentRoom, String roomName, Components.NodeMonster monster, boolean isLeft) {
        NodeRoom parent = findRoom(root, parentRoom);
        if (parent != null) {
            NodeRoom newRoom = new NodeRoom(roomName, monster);
            if (isLeft) {
                parent.left = newRoom;
            } else {
                parent.right = newRoom;
            }
        }
    }

    private NodeRoom findRoom(NodeRoom current, String roomName) {
        if (current == null) return null;
        if (current.roomName.equals(roomName)) return current;

        NodeRoom foundRoom = findRoom(current.left, roomName);
        if (foundRoom == null) {
            foundRoom = findRoom(current.right, roomName);
        }
        return foundRoom;
    }

    // Explore map
    public void explore(Components.NodePlayer player) {
        exploreRoom(root, player);
    }

    private void exploreRoom(NodeRoom current, Components.NodePlayer player) {
        if (current == null) return;
    
        // Encounter monster if present
        if (current.monster != null) {
            System.out.println("You encountered a " + current.monster.namaMonster + "!");
            boolean isVictory = Battle.fight(player, current.monster, player.playerSkills, player.inventory);
            if (!isVictory) {
                System.out.println("Game Over! You were defeated.");
                return;
            }
            //hapus monster
            current.monster = null;
        }
    
        // Check if the current room is a dead end
        if (current.left == null && current.right == null) {
            System.out.println("You've reached the end of this path.");
            return;
        }
    
        System.out.println("Choose your path:");
        if (current.left != null) {
            System.out.println("1. Go left to " + current.left.roomName);
        }
        if (current.right != null) {
            System.out.println("2. Go right to " + current.right.roomName);
        }
    
        int choice = getValidInput();
    
        // rekursif eksplorasi
        if (choice == 1 && current.left != null) {
            exploreRoom(current.left, player);
        } else if (choice == 2 && current.right != null) {
            exploreRoom(current.right, player);
        } else {
            System.out.println("Invalid choice, please choose again.");
            exploreRoom(current, player);
        }
    }

    private int getValidInput() {
        while (true) {
            // Periksa apakah input tersedia
            if (!scanner.hasNext()) {
                System.out.println("No input detected. Exiting game.");
                System.exit(0); // Keluar dengan cara yang aman jika tidak ada input
            }
    
            // Validasi input sebagai angka
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice == 1 || choice == 2) {
                    return choice; // Input valid
                } else {
                    System.out.println("Invalid choice. Please select 1 or 2.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Abaikan input tidak valid
            }
        }
    }

}