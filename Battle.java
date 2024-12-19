import java.util.Scanner;

public class Battle {
    public static void fight(NodePlayer player, NodeMonster monster, Skill Skillmanager, Linkedlist_item inventory) {
        Scanner scanner = new Scanner(System.in);
        AttackStack attackStack = new AttackStack();

        while (player.healthPlayer > 0 && monster.healthMonster > 0) {
            // Display health status
            System.out.println(player.namaPlayer + " Health: " + player.healthPlayer);
            System.out.println(monster.namaMonster + " Health: " + monster.healthMonster);
            
            // Action choices
            System.out.println("Choose your action:");
            System.out.println("1. Attack");
            System.out.println("2. Use Skill");
            System.out.println("3. Use Item");
            System.out.println("4. Execute Actions from Stack");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Choose your weapon:");
                    System.out.println("1. Shadowfang");
                    System.out.println("2. Crimson Vortex");
                    int weaponChoice = scanner.nextInt();
                    String weaponAction = weaponChoice == 1 ? "Shadowfang" : "Crimson Vortex";
                    attackStack.addAttack(weaponAction);
                    break;

                case 2:
                    System.out.println("Choose your skill:");
                    System.out.println("1. " + Skillmanager.skill1.namaPlayer);
                    System.out.println("2. " + Skillmanager.skill2.namaPlayer);
                    System.out.println("3. " + Skillmanager.skill3.namaPlayer);
                    int skillChoice = scanner.nextInt();
                    Skillmanager.tambahSkill(skillChoice);
                    String skillAction = Skillmanager.skill.namaPlayer;
                    attackStack.addAttack(skillAction);
                    break;

                case 3:
                    System.out.println("Choose your item type:");
                    System.out.println("1. Armor");
                    System.out.println("2. Potion");
                    int itemTypeChoice = scanner.nextInt();
                    
                    if (itemTypeChoice == 1) {
                        System.out.println("Choose armor:");
                        System.out.println("1. Nightshade Plate");
                        System.out.println("2. Ironveil");
                        int armorChoice = scanner.nextInt();
                        String armorAction = armorChoice == 1 ? "Nightshade Plate" : "Ironveil";
                        attackStack.addAttack(armorAction);
                    } else if (itemTypeChoice == 2) {
                        System.out.println("Choose potion:");
                        System.out.println("1. Elixir of Shadows");
                        System.out.println("2. Lifeblood Brew");
                        int potionChoice = scanner.nextInt();
                        String potionAction = potionChoice == 1 ? "Elixir of Shadows" : "Lifeblood Brew";
                        attackStack.addAttack(potionAction);
                    }
                    break;

                case 4:
                    while (true) {
                        String action = attackStack.useAttack();
                        if (action == null) break;
                        executeAction(action, player, monster, inventory);
                    }
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
                    continue;
            }

            // Monster attack phase
            if (monster.healthMonster > 0) {
                int damageToPlayer = monster.attackMonster - player.defensePlayer;
                if (damageToPlayer > 0) {
                    player.healthPlayer -= damageToPlayer;
                    System.out.println(monster.namaMonster + " attacks " + player.namaPlayer + " for " + damageToPlayer + " damage.");
                } else {
                    System.out.println(monster.namaMonster + " attacks but it's not effective.");
                }
            }
        }

        // Battle conclusion
        if (player.healthPlayer > 0) {
            System.out.println(player.namaPlayer + " has defeated " + monster.namaMonster);
        } else {
            System.out.println(player.namaPlayer + " has been defeated by " + monster.namaMonster);
        }
    }

    private static void executeAction(String action, NodePlayer player, NodeMonster monster, Linkedlist_item inventory) {
        // Find the item in inventory
        NodeItem currentItem = inventory.head;
        while (currentItem != null) {
            if (currentItem.namaItem.equals(action)) {
                break;
            }
            currentItem = currentItem.next;
        }

        switch (action) {
            // Weapons
            case "Shadowfang":
                if (currentItem instanceof NodeItem.Weapon) {
                    NodeItem.Weapon weapon = (NodeItem.Weapon) currentItem;
                    int damage = player.attackPlayer + weapon.power;
                    monster.healthMonster -= damage;
                    System.out.println(player.namaPlayer + " attacks with Shadowfang for " + damage + " damage!");
                }
                break;

            case "Crimson Vortex":
                if (currentItem instanceof NodeItem.Weapon) {
                    NodeItem.Weapon weapon = (NodeItem.Weapon) currentItem;
                    int damage = (int)((player.attackPlayer + weapon.power) * 1.2); // 20% bonus damage
                    monster.healthMonster -= damage;
                    System.out.println(player.namaPlayer + " unleashes Crimson Vortex for " + damage + " damage!");
                }
                break;

            // Armor
            case "Nightshade Plate":
                if (currentItem instanceof NodeItem.Armor) {
                    NodeItem.Armor armor = (NodeItem.Armor) currentItem;
                    player.defensePlayer += armor.defense;
                    System.out.println(player.namaPlayer + " equips Nightshade Plate and gains " + armor.defense + " defense!");
                }
                break;

            case "Ironveil":
                if (currentItem instanceof NodeItem.Armor) {
                    NodeItem.Armor armor = (NodeItem.Armor) currentItem;
                    player.defensePlayer += armor.defense;
                    System.out.println(player.namaPlayer + " equips Ironveil and gains " + armor.defense + " defense!");
                }
                break;

            // Potions
            case "Elixir of Shadows":
                if (currentItem instanceof NodeItem.Potion) {
                    NodeItem.Potion potion = (NodeItem.Potion) currentItem;
                    player.attackPlayer += potion.attackAmount;
                    player.healthPlayer += potion.healingAmount;
                    System.out.println(player.namaPlayer + " drinks Elixir of Shadows and gains " + 
                                     potion.attackAmount + " attack and " + potion.healingAmount + " health!");
                }
                break;

            case "Lifeblood Brew":
                if (currentItem instanceof NodeItem.Potion) {
                    NodeItem.Potion potion = (NodeItem.Potion) currentItem;
                    player.healthPlayer += potion.healingAmount;
                    System.out.println(player.namaPlayer + " drinks Lifeblood Brew and recovers " + 
                                     potion.healingAmount + " health!");
                }
                break;

            // Skills
            case "Blazing Strike":
                int blazingDamage = player.playerSkills.skill1.attackSkill1;
                monster.healthMonster -= blazingDamage;
                System.out.println(player.namaPlayer + " uses Blazing Strike for " + blazingDamage + " damage!");
                break;

            case "Mystic Barrier":
                int defenseIncrease = player.playerSkills.skill2.attackSkill2;
                player.defensePlayer += defenseIncrease;
                System.out.println(player.namaPlayer + " uses Mystic Barrier and gains " + defenseIncrease + " defense!");
                break;

            case "Divine Restoration":
                int healAmount = player.playerSkills.skill3.heal;
                player.healthPlayer += healAmount;
                System.out.println(player.namaPlayer + " uses Divine Restoration and heals for " + healAmount + " health!");
                break;

            default:
                System.out.println("Unknown action: " + action);
                break;
        }
    }
}