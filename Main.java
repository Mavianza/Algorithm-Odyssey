import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Item initialization (unchanged)
        Linkedlist_item item = new Linkedlist_item();
        NodeItem Backpack = new NodeItem("ber", 0, false);
        NodeItem.Weapon weapon_1 = Backpack.new Weapon("Shadowfang", 0, false, 0);
        NodeItem.Armor armor_1 = Backpack.new Armor("Nightshade Plate", 0, false, 0);
        NodeItem.Potion potion_1 = Backpack.new Potion("Elixir of Shadows", 0, false, 0, 0);
        
        NodeItem.Weapon weapon_2 = Backpack.new Weapon("Crimson Vortex", 0, false, 0);
        NodeItem.Armor armor_2 = Backpack.new Armor("Ironveil", 0, false, 0);
        NodeItem.Potion potion_2 = Backpack.new Potion("Lifeblood Brew", 0, false, 0, 0);

        item.tambahData(weapon_1);
        item.tambahData(weapon_2);
        item.tambahData(armor_1);
        item.tambahData(armor_2);
        item.tambahData(potion_1);
        item.tambahData(potion_2);
        
        item.displayItems();

        // Create player and monster instances
        NodePlayer player = new NodePlayer("Hero", 100, 15, 5);
        NodeMonster monster1 = new NodeMonster("Goblin", 30, 5, 2, 5);
        NodeMonster monster2 = new NodeMonster("Orc", 50, 10, 5, 10);

        // Create skill and set it to player
        Skill skill = new Skill(player);
      //  player.setSkills(skill);

        // Start battles
        Battle.fight(player, monster1, skill, item);

        if (player.healthPlayer > 0) {
            System.out.println("Moving to the next monster: " + monster2.namaMonster);
            Battle.fight(player, monster2, skill, item);
        }

        scanner.close();
    }
}