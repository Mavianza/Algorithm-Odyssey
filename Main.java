public class Main {
    public static void main(String[] args) {
        Linkedlist_item item = new Linkedlist_item();
        //setiap level itemnya berbeda untuk player;
        NodePlayer pemain = new NodePlayer("pemain", 0, 0, 0, "player");
        NodeItem Backpack = new NodeItem("ber", 0, false);
        NodeItem.Weapon weapon_1 = Backpack.new Weapon("Shadowfang", 0, false, 0);
        NodeItem.Armor armor_1 = Backpack.new Armor("Nightshade Plate", 0, false, 0);
        NodeItem.Potion potion_1 = Backpack.new Potion("Elixir of Shadows", 0, false, 0, 0);
        
        NodeItem.Weapon weapon_2 = Backpack.new Weapon("Crimson Vortex", 0, false, 0);
        NodeItem.Armor armor_2 = Backpack.new Armor("Ironveil", 0, false, 0);
        NodeItem.Potion potion_2 = Backpack.new Potion("Lifeblood Brew", 0, false, 0, 0);
        
        NodeItem.Weapon weapon_3 = Backpack.new Weapon("Voidsplitter", 0, false, 0);
        NodeItem.Armor armor_3 = Backpack.new Armor("Emberforge Suit", 0, false, 0);
        NodeItem.Potion potion_3 = Backpack.new Potion("Etherflask", 0, false, 0, 0);
       
        NodeItem.Weapon weapon_4 = Backpack.new Weapon("Arcane Reaver", 0, false, 0);
        NodeItem.Armor armor_4 = Backpack.new Armor("Frostbound Cloak", 0, false, 0);
        NodeItem.Potion potion_4 = Backpack.new Potion("Dragonfire Tonic", 0, false, 0, 0);
       
        NodeItem.Weapon weapon_5 = Backpack.new Weapon("Stormrend", 0, false, 0);
        NodeItem.Armor armor_5 = Backpack.new Armor("Shatterguard", 0, false, 0);
        NodeItem.Potion potion_5 = Backpack.new Potion("Spiritbound Vial", 0, false, 0, 0);
       
        NodeItem.Weapon weapon_6 = Backpack.new Weapon("Soulpiercer", 0, false, 0);
        NodeItem.Armor armor_6 = Backpack.new Armor("Astral Mantle", 0, false, 0);
        NodeItem.Potion potion_6 = Backpack.new Potion("Crimson Nectar", 0, false, 0, 0);
    }   
}
