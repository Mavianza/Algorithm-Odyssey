public class NodeItem {
    NodeItem next = null;
    String senjata;
    int damage;
    String armor;
    int defense;
    String potion;
    int healingAmount;
    String item_khusus;

    NodeItem(String senjata, int damage, String armor, int defense, String potion, int healingAmount, String item_khusus){
        this.senjata = senjata;
        this.damage = damage;
        this.armor = armor;
        this.defense = defense;
        this.potion = potion;
        this.healingAmount = healingAmount;
        this.item_khusus = item_khusus;
    }
}
