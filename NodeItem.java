public class NodeItem {
    NodeItem next = null;
    String namaItem;
    int damage;
    boolean item_khusus;
    
    NodeItem(String namaItem, int damage, boolean item_khusus) {
        this.namaItem = namaItem;
        this.damage = damage;
        this.item_khusus = item_khusus;
        this.next = null;
    }
    class Weapon extends NodeItem {
        int power;
        
        Weapon(String namaItem, int damage, boolean item_khusus, int power) {
            super(namaItem, damage,item_khusus);
            this.power = power;
        }
    }
    
    class Armor extends NodeItem {
        int defense;
        Armor(String namaItem, int damage, boolean item_khusus, int defense) {
            super(namaItem, damage, item_khusus);
            this.defense = defense;
        }
    }
    
    class Potion extends NodeItem {
        int healingAmount;
        Potion(String namaItem, int damage, boolean item_khusus, int healingAmount) {
            super(namaItem, damage, item_khusus);
            this.healingAmount = healingAmount;
        }
    }
}
