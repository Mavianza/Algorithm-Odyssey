import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inisialisasi item untuk inventory
        Linkedlist_item item = new Linkedlist_item();
        initializeItems(item);

        // Inisialisasi inventory pemain
        Components.Inventory inventory = new Components.Inventory();
        initializeInventory(inventory);

        // Inisialisasi player, monster, dan skill
        Components.NodePlayer player = new Components.NodePlayer("Hero", 100, 15, 5);
        Components.NodeMonster goblin = new Components.NodeMonster("Goblin", 30, 5, 2, 5);
        Components.NodeMonster orc = new Components.NodeMonster("Orc", 50, 10, 5, 10);
        Components.NodeMonster almaMonster = new Components.NodeMonster("Alma", 100, 20, 10, 20);
        Components.NodeMonster dragon = new Components.NodeMonster("Dragon", 200, 50, 20, 50);
        Components.Skill skill = new Components.Skill(player);
        player.setSkill(skill);

        // Buat map dan tambahkan ruangan
        GameMap map = new GameMap(scanner);
        map.addRoot("Entrance", goblin);
        map.addRoom("Entrance", "Dragon's Lair", orc, true); // Ruangan di kiri
        map.addRoom("Entrance", "Treasure Room", null, false); // Ruangan di kanan
        map.addRoom("Dragon's Lair", "Alma's Lair", almaMonster, true); // Ruangan di kiri
        map.addRoom("Dragon's Lair", "Dragon's Lair", dragon, false); // Ruangan di kanan

        // Mulai eksplorasi
        map.explore(player);

        scanner.close();
    }

    private static void initializeItems(Linkedlist_item item) {
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
    }

    private static void initializeInventory(Components.Inventory inventory) {
        inventory.addItem("Shadowfang");
        inventory.addItem("Fireball");
        inventory.addItem("Health Potion");
    }
}