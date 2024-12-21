import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Linkedlist_item item = new Linkedlist_item();
        initializeItems(item);

        Components.Inventory inventory = new Components.Inventory();
        initializeInventory(inventory);

        Components.NodePlayer player = new Components.NodePlayer("Hero", 150, 20, 10);

    Components.NodeMonster goblin = new Components.NodeMonster("Goblin", 80, 5, 15);
    Components.NodeMonster orc = new Components.NodeMonster("Orc", 120, 8, 20);
    Components.NodeMonster troll = new Components.NodeMonster("Troll", 180, 12, 25);
    Components.NodeMonster almaMonster = new Components.NodeMonster("Alma", 220, 15, 35);
    Components.NodeMonster dragon = new Components.NodeMonster("Dragon", 300, 20, 50);
    Components.NodeMonster demonLord = new Components.NodeMonster("Demon Lord", 400, 25, 65);
    Components.Skill skill = new Components.Skill(player);
        player.setSkill(skill);
        // Create map with tree structure:
        //                             Entrance (Goblin)
        //                    /           |              \
        //          Empty Room 1    Spike Trap Room    Orc Den (Orc)
        //                                    |
        //                              /     |        \
        //                    Empty Room 2  Poison Trap  Troll Cave (Troll)
        //                                              |
        //                                        /     |        \
        //                              Empty Room 3  Lava Trap  Alma's Lair (Alma)
        //                                                      |
        //                                                /     |        \
        //                                      Empty Room 4  Crushing Trap  Dragon's Lair (Dragon)
        //                                                              |
        //                                                        /     |        \
        //                                          Empty Room 5  Cursed Trap  Demon's Throne (DemonLord)
        //                                                                  |
        //                                                            /     |        \
        //                                              Empty Room 6  Abyss Trap  Final Chamber
        GameMap map = new GameMap(scanner);

        // Level 1
        map.addRoot("Entrance", goblin);
        map.addRoom("Entrance", "Empty Room 1", null, true);
        map.addRoom("Entrance", "Spike Trap Room", null, false);
        map.addRoom("Entrance", "Orc Den", orc, false);
        
        // Level 2
        map.addRoom("Orc Den", "Empty Room 2", null, true);
        map.addRoom("Orc Den", "Poison Trap Room", null, false);
        map.addRoom("Orc Den", "Troll Cave", troll, false);
        
        // Level 3
        map.addRoom("Troll Cave", "Empty Room 3", null, true);
        map.addRoom("Troll Cave", "Lava Trap Room", null, false);
        map.addRoom("Troll Cave", "Alma's Lair", almaMonster, false);
        
        // Level 4
        map.addRoom("Alma's Lair", "Empty Room 4", null, true);
        map.addRoom("Alma's Lair", "Crushing Trap Room", null, false);
        map.addRoom("Alma's Lair", "Dragon's Lair", dragon, false);
        
        // Level 5
        map.addRoom("Dragon's Lair", "Empty Room 5", null, true);
        map.addRoom("Dragon's Lair", "Cursed Trap Room", null, false);
        map.addRoom("Dragon's Lair", "Demon's Throne", demonLord, false);
        
        // Level 6 (Final Level)
        map.addRoom("Demon's Throne", "Empty Room 6", null, true);
        map.addRoom("Demon's Throne", "Abyss Trap Room", null, false);
        map.addRoom("Demon's Throne", "Final Chamber", null, false);
    map.explore(player);

        scanner.close();
    }

    private static void initializeItems(Linkedlist_item item) {
        Components.NodeItem.Weapon weapon_1 = new Components.NodeItem.Weapon("Shadowfang", 25, false, 15);
        Components.NodeItem.Armor armor_1 = new Components.NodeItem.Armor("Nightshade Plate", 0, false, 15);
        Components.NodeItem.Potion potion_1 = new Components.NodeItem.Potion("Elixir of Shadows", 0, false, 30, 15);

        Components.NodeItem.Weapon weapon_2 = new Components.NodeItem.Weapon("Crimson Vortex", 35, false, 20);
        Components.NodeItem.Armor armor_2 = new Components.NodeItem.Armor("Ironveil", 0, false, 25);
        Components.NodeItem.Potion potion_2 = new Components.NodeItem.Potion("Lifeblood Brew", 0, false, 50, 0);

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