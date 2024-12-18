import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Item level
        Linkedlist_item item = new Linkedlist_item();
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

        item.tambahData(weapon_1);
        item.tambahData(weapon_2);
        item.tambahData(weapon_3);
        item.tambahData(weapon_4);
        item.tambahData(weapon_5);
        item.tambahData(weapon_6);
        item.tambahData(armor_1);
        item.tambahData(armor_2);
        item.tambahData(armor_3);
        item.tambahData(armor_4);
        item.tambahData(armor_5);
        item.tambahData(armor_6);
        item.tambahData(potion_1);
        item.tambahData(potion_2);
        item.tambahData(potion_3);
        item.tambahData(potion_4);

        item.tambahData(potion_5);
        item.tambahData(potion_6);

        // Membuat monster
        NodeMonster monster1 = new NodeMonster("Goblin", 30, 5, 2, 5);
        NodeMonster monster2 = new NodeMonster("Orc", 50, 10, 5, 10);

        // Membuat pemain
        NodePlayer player = new NodePlayer("Hero", 100, 15, 5);

        // Memulai pertarungan dengan monster pertama
        Battle.fight(player, monster1);
        Battle.fight(player, monster2);

        // Jika pemain masih hidup, lanjutkan ke monster berikutnya
        if (player.healthPlayer > 0) {
            System.out.println("Moving to the next monster: " + monster2.namaMonster);
            Battle.fight(player, monster2); // Pertarungan dengan monster kedua
        }

        scanner.close();
    }
}