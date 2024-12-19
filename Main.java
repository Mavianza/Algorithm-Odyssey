import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // backpack saya hapus soalnya inikan buat objek dari subclass jadi kurang efisien dan error juga wkwk
        Linkedlist_item item = new Linkedlist_item();
        Components.NodeItem.Weapon weapon_1 = new Components.NodeItem.Weapon("Shadowfang", 10, false, 0);
        Components.NodeItem.Armor armor_1 = new Components.NodeItem.Armor("Nightshade Plate", 0, false, 0);
        Components.NodeItem.Potion potion_1 = new Components.NodeItem.Potion("Elixir of Shadows", 0, false, 0, 0);

        Components.NodeItem.Weapon weapon_2 = new Components.NodeItem.Weapon("Crimson Vortex", 0, false, 0);
        Components.NodeItem.Armor armor_2 = new Components.NodeItem.Armor("Ironveil", 0, false, 0);
        Components.NodeItem.Potion potion_2 = new Components.NodeItem.Potion("Lifeblood Brew", 0, false, 0, 0);


        item.tambahData(weapon_1);
        item.tambahData(weapon_2);
        item.tambahData(armor_1);
        item.tambahData(armor_2);
        item.tambahData(potion_1);
        item.tambahData(potion_2);
        
        item.displayItems();

        // Create player and monster instances
        Components.NodePlayer player = new Components.NodePlayer("Hero", 100, 15, 5);
        Components.NodeMonster monster1 = new Components.NodeMonster("Goblin", 30, 5, 2, 5);
        Components.NodeMonster monster2 = new Components.NodeMonster("Orc", 50, 10, 5, 10);

        // Create skill and set it to player
        Components.Skill skill = new Components.Skill(player);
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