public class Components {
    //skill
    public static class NodePlayer {
        String namaPlayer;
        int healthPlayer;
        int attackPlayer;
        int defensePlayer;
        Linkedlist_item inventory; // Menyimpan senjata, skill, dan item
        Skill playerSkills; // Tambahkan reference ke Skill
        // NodePlayer player;

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
        
        // Subclass Skill
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
            // Menghubungkan skill dengan NodePlayer
            this.skill1 = new NodePlayer.SkillSatu("Blazing Strike", player.healthPlayer, player.attackPlayer, player.defensePlayer, 69);
            this.skill2 = new NodePlayer.SkillDua("Mystic Barrier", player.healthPlayer, player.attackPlayer, player.defensePlayer, 100);
            this.skill3 = new NodePlayer.SkillTiga("Divine Restoration", player.healthPlayer, player.attackPlayer, player.defensePlayer, 911);
        }

        public void tambahSkill(int skillChoice) {
            switch (skillChoice) {
                case 1: // Tambah Skill 1
                    System.out.println(skill1.namaPlayer + " menggunakan " + skill1.namaPlayer + "! Damage: " + skill1.attackSkill1);
                    break;
                case 2: // Tambah Skill 2
                    System.out.println(skill2.namaPlayer + " menggunakan " + skill2.namaPlayer + "! Defense meningkat sebesar " + skill2.attackSkill2);
                    break;
                case 3: // Tambah Skill 3
                    System.out.println(skill3.namaPlayer + " menggunakan " + skill3.namaPlayer + "! Health bertambah sebesar " + skill3.heal);
                    break;
                default:
                    System.out.println("Pilihan skill tidak valid.");
            }
        }
    }
    //Inventory
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
            return null; // Jika tidak ada item pada index tersebut
        }
    }


    //Monster
    public static class NodeMonster {
        String namaMonster;
        int healthMonster;
        int attackMonster;
        int defenseMonster;
        NodeMonster next = null;

        public NodeMonster(String namaMonster, int healthMonster, int damageMonster, int defenseMonster,int attackMonster) {
            this.namaMonster = namaMonster;
            this.healthMonster = healthMonster;
            this.attackMonster = attackMonster;
            this.defenseMonster = defenseMonster;
            this.next = null;
        }
    }
    //item
    public static class NodeItem {
        String namaItem;
        int damage;
        boolean itemKhusus;
        NodeItem next;

        public NodeItem(String namaItem, int damage, boolean itemKhusus) {
            this.namaItem = namaItem;
            this.damage = damage;
            this.itemKhusus = itemKhusus;
            this.next = null;
        }

        // Subclass Weapon
        public static class Weapon extends NodeItem {
            int power;

            public Weapon(String namaItem, int damage, boolean itemKhusus, int power) {
                super(namaItem, damage, itemKhusus);
                this.power = power;
            }
        }

        // Subclass Armor
        public static class Armor extends NodeItem {
            int defense;

            public Armor(String namaItem, int damage, boolean itemKhusus, int defense) {
                super(namaItem, damage, itemKhusus);
                this.defense = defense;
            }
        }

        // Subclass Potion
        // public static class Potion extends NodeItem {
        //     int healingAmount;
        //     int attackAmount;

        //     public Potion(String namaItem, int damage, boolean itemKhusus, int healingAmount, int attackAmount) {
        //         super(namaItem, damage, itemKhusus);
        //         this.healingAmount = healingAmount;
        //         this.attackAmount = attackAmount;
        //     }
        // }

        public static class Potion extends NodeItem {
            int healingAmount;
            int attackAmount;
        
            public Potion(String namaItem, int damage, boolean itemKhusus, int healingAmount, int attackAmount) {
                super(namaItem, damage, itemKhusus);
                this.healingAmount = healingAmount;
                this.attackAmount = attackAmount;
            }
        }
    }
    //attack stack
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
                return null; // Jika stack kosong
            }
            String attack = top.attack;
            top = top.next;
            return attack;
        }
    }
}
