import java.util.Scanner;

public class Components {
    public static class NodePlayer {
        String namaPlayer;
        int healthPlayer;
        int attackPlayer;
        int defensePlayer;
        Linkedlist_item inventory;
        Skill playerSkills; 

        public NodePlayer(String namaPlayer, int healthPlayer, int attackPlayer, int defensePlayer) {
            this.namaPlayer = namaPlayer;
            this.healthPlayer = healthPlayer;
            this.attackPlayer = attackPlayer;
            this.defensePlayer = defensePlayer;
            this.inventory = new Linkedlist_item();
        }
        public void setSkill(Skill skill) {
            this.playerSkills = skill;
        }

        public static class SkillSatu extends NodePlayer {
            int attackSkill1;

            public SkillSatu(String namaSkill, int healthPlayer, int attackPlayer, int defensePlayer, int attackSkill1) {
                super(namaSkill, healthPlayer, attackPlayer, defensePlayer);
                this.attackSkill1 = attackSkill1;
            }
        }

        public static class SkillDua extends NodePlayer {
            int attackSkill2;

            public SkillDua(String namaSkill, int healthPlayer, int attackPlayer, int defensePlayer, int attackSkill2) {
                super(namaSkill, healthPlayer, attackPlayer, defensePlayer);
                this.attackSkill2 = attackSkill2;
            }
        }

        public static class SkillTiga extends NodePlayer {
            int heal;

            public SkillTiga(String namaSkill, int healthPlayer, int attackPlayer, int defensePlayer, int heal) {
                super(namaSkill, healthPlayer, attackPlayer, defensePlayer);
                this.heal = heal;
            }
        }
    }

    public static class Skill{
        NodePlayer.SkillSatu skill1;
        NodePlayer.SkillDua skill2;
        NodePlayer.SkillTiga skill3;

        public Skill(NodePlayer player) {
            this.skill1 = new NodePlayer.SkillSatu("Blazing Strike", player.healthPlayer, player.attackPlayer, player.defensePlayer, 69);
            this.skill2 = new NodePlayer.SkillDua("Mystic Barrier", player.healthPlayer, player.attackPlayer, player.defensePlayer, 100);
            this.skill3 = new NodePlayer.SkillTiga("Divine Restoration", player.healthPlayer, player.attackPlayer, player.defensePlayer, 911);
        }

        public void tambahSkill(int skillChoice) {
            switch (skillChoice) {
                case 1: 
                    System.out.println(skill1.namaPlayer + " menggunakan " + skill1.namaPlayer + "! Damage: " + skill1.attackSkill1);
                    break;
                case 2: 
                    System.out.println(skill2.namaPlayer + " menggunakan " + skill2.namaPlayer + "! Defense meningkat sebesar " + skill2.attackSkill2);
                    break;
                case 3:
                    System.out.println(skill3.namaPlayer + " menggunakan " + skill3.namaPlayer + "! Health bertambah sebesar " + skill3.heal);
                    break;
                default:
                    System.out.println("Pilihan skill tidak valid.");
            }
        }
    }

    public static class Inventory {
        NodeInventory head;

        public Inventory() {
            head = null;
        }

        public void addItem(String itemName) {
            NodeInventory newItem = new NodeInventory(itemName);
            if (head == null) {
                head = newItem;
            } else {
                NodeInventory current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newItem;
            }
        }

        public void displayItems() {
            NodeInventory current = head;
            int index = 1;
            while (current != null) {
                System.out.println(index + ". " + current.itemName);
                current = current.next;
                index++;
            }
        }

        public String getItem(int index) {
            NodeInventory current = head;
            int count = 1;
            while (current != null) {
                if (count == index) {
                    return current.itemName;
                }
                current = current.next;
                count++;
            }
            return null; 
        }
    }

    public static class NodeMonster {
        String namaMonster;
        int healthMonster;
        int attackMonster;
        int defenseMonster;
        NodeMonster next = null;

        public NodeMonster(String namaMonster, int healthMonster, int defenseMonster,int attackMonster) {
            this.namaMonster = namaMonster;
            this.healthMonster = healthMonster;
            this.attackMonster = attackMonster;
            this.defenseMonster = defenseMonster;
            this.next = null;
        }

        public String getName(){
            return namaMonster;
        }
        public void setName(String namaMonster){
            this.namaMonster = namaMonster;
        }
        public int getHealth(){
            return healthMonster;
        }
        public void setHealth(int healthMonster){
            this.healthMonster = healthMonster;
        }

    }
    
    public static class NodeItem {
        String namaItem;
        int damage;
        NodeItem next;

        public NodeItem(String namaItem, int damage) {
            this.namaItem = namaItem;
            this.damage = damage;
            this.next = null;
        }

        public static class Weapon extends NodeItem {
            int power;

            public Weapon(String namaItem, int damage, int power) {
                super(namaItem, damage);
                this.power = power;
            }
        }

        public static class Armor extends NodeItem {
            int defense;

            public Armor(String namaItem, int damage, int defense) {
                super(namaItem, damage);
                this.defense = defense;
            }
        }

        public static class Potion extends NodeItem {
            int healingAmount;
            int attackAmount;
        
            public Potion(String namaItem, int damage, int healingAmount, int attackAmount) {
                super(namaItem, damage);
                this.healingAmount = healingAmount;
                this.attackAmount = attackAmount;
            }
        }
    }
    
    public static class AttackStack {
        private class StackNode {
            String attack;
            StackNode next;
    
            StackNode(String attack) {
                this.attack = attack;
                this.next = null;
            }
        }
    
        private StackNode top;
    
        public AttackStack() {
            top = null;
        }
    
        public void addAttack(String attack) {
            StackNode newNode = new StackNode(attack);
            newNode.next = top;
            top = newNode;
            System.out.println(attack + " has been added to the stack.");
        }
    
        public String useAttack() {
            if (top == null) {
                return null; 
            }
            String attack = top.attack;
            top = top.next;
            return attack;
        }
    
        public boolean isEmpty() {
            return top == null;
        }
    }
    static class QueueNode {
        String participant;
        QueueNode next;

        QueueNode(String participant) {
            this.participant = participant;
            this.next = null;
        }
    }
    public static class BattleQueue{
        private QueueNode front;
        private QueueNode rear;

        public BattleQueue() {
            this.front = null;
            this.rear = null;
        }
        public void enqueue(String participant) {
            QueueNode newNode = new QueueNode(participant);
            
            if (rear == null) {
                front = rear = newNode;
                return;
            }
            rear.next = newNode;
            rear = newNode;
        }
        public String dequeue() {
            if (front == null) return null;
            
            String participant = front.participant;
            front = front.next;
            
            if (front == null) {
                rear = null;
            }
            return participant;
        }

        public boolean isEmpty() {
            return front == null;
        }
    }
   
    public static void showSortSearchMenu(Scanner scanner, Linkedlist_monster monster) {
        while (true) {
            System.out.println("╔═════════════════════════════╗");
            System.out.println("║    Sort & Search Menu       ║");
            System.out.println("╚═════════════════════════════╝");
            System.out.println("1. Sort Monster by Name");
            System.out.println("2. Sort Monster by Health");
            System.out.println("3. Search Monster by Name");
            System.out.println("4. Back to Main Menu");
            System.out.print(">> ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            Battle.clearScreen();
            
            switch (choice) {
                case 1:
                    sortMonsterByName(monster);
                    break;
                case 2:
                    sortMonsterByHealth(monster);
                    break;
                case 3:
                    System.out.print("Enter Monster Name to search: ");
                    String searchName = scanner.nextLine();
                    searchMonsterByName(monster, searchName);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void sortMonsterByName(Linkedlist_monster monster) {
        Components.NodeMonster current = monster.head;
        Components.NodeMonster index = null;
        
        if (monster.head == null) {
            System.out.println("There are no Monster!");
            return;
        }
        
        while (current != null) {
            index = current.next;
            while (index != null) {
                if (current.getName().compareTo(index.getName()) > 0) {
                    // Swap nama
                    String tempName = current.getName();
                    current.setName(index.getName());
                    index.setName(tempName);
                    
                    // Swap health
                    int tempHealth = current.getHealth();
                    current.setHealth(tempHealth);
                    index.setHealth(tempHealth);
                }
                index = index.next;
            }
            current = current.next;
        }
        
        System.out.println("\nMonsters sorted by name:");
        printMonsters(monster);
    }

    private static void sortMonsterByHealth(Linkedlist_monster monster) {
        Components.NodeMonster current = monster.head;
        Components.NodeMonster index = null;
        
        if (monster.head == null) {
            System.out.println("There are no Monster");
            return;
        }
        
        while (current != null) {
            index = current.next;
            while (index != null) {
                if (current.getHealth() > index.getHealth()) {
                   
                    String tempName = current.getName();
                    current.setName(index.getName());
                    index.setName(tempName);
                    
                    int tempHealth = current.getHealth();
                    current.setHealth(tempHealth);
                    index.setHealth(tempHealth);
                }
                index = index.next;
            }
            current = current.next;
        }
        
        System.out.println("\nMonsters sorted by Health:");
        printMonsters(monster);
    }

    private static void searchMonsterByName(Linkedlist_monster monster, String searchName) {
        Components.NodeMonster current = monster.head;
        boolean found = false;
        
        System.out.println("\nSearch results for '" + searchName + "':");
        System.out.println("----------------------------------------");
        
        while (current != null) {
            if (current.getName().toLowerCase().contains(searchName.toLowerCase())) {
                System.out.println("Name: " + current.getName());
                System.out.println("Health: " + current.getHealth());
                System.out.println("----------------------------------------");
                found = true;
            }
            current = current.next;
        }
        
        if (!found) {
            System.out.println("No monster found matching '" + searchName + "'");
        }
    }

    private static void printMonsters(Linkedlist_monster monster) {
        Components.NodeMonster current = monster.head;
        System.out.println("----------------------------------------");
        while (current != null) {
            System.out.println("Name: " + current.getName());
            System.out.println("Health: " + current.getHealth());
            System.out.println("----------------------------------------");
            current = current.next;
        }
    }
}