import java.util.Scanner;

public class Battle {
    public static void fight(Components.NodePlayer player, Components.NodeMonster monster, Components.Skill Skillmanager, Linkedlist_item inventory) {
        Scanner scanner = new Scanner(System.in);
        Components.AttackStack attackStack = new Components.AttackStack();

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
                
                    String skillAction;
                    switch (skillChoice) {
                        case 1: // Blazing Strike
                            skillAction = Skillmanager.skill1.namaPlayer;
                            monster.healthMonster -= Skillmanager.skill1.attackSkill1;
                            System.out.println(player.namaPlayer + " uses " + skillAction + " for " + Skillmanager.skill1.attackSkill1 + " damage!");
                            break;
                
                        case 2: // Mystic Barrier
                            skillAction = Skillmanager.skill2.namaPlayer;
                            player.defensePlayer += Skillmanager.skill2.attackSkill2;
                            System.out.println(player.namaPlayer + " uses " + skillAction + " and gains " + Skillmanager.skill2.attackSkill2 + " defense!");
                            break;
                
                        case 3: // Divine Restoration
                            skillAction = Skillmanager.skill3.namaPlayer;
                            player.healthPlayer += Skillmanager.skill3.heal;
                            System.out.println(player.namaPlayer + " uses " + skillAction + " and heals for " + Skillmanager.skill3.heal + " health!");
                            break;
                
                        default:
                            System.out.println("Invalid skill choice.");
                            continue;
                    }
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

    private static void executeAction(String action, Components.NodePlayer player, Components.NodeMonster monster, Linkedlist_item inventory) {
        // Find the item in inventory
        Components.NodeItem currentItem = inventory.head;
        while (currentItem != null) {
            if (currentItem.namaItem.equals(action)) {
                break;
            }
            currentItem = currentItem.next;
        }

        switch (action) {
            // Weapons
            case "Shadowfang":
                if (currentItem instanceof Components.NodeItem.Weapon) {
                    Components.NodeItem.Weapon weapon = (Components.NodeItem.Weapon) currentItem;
                    int damage = player.attackPlayer + weapon.power;
                    monster.healthMonster -= damage;
                    System.out.println(player.namaPlayer + " attacks with Shadowfang for " + damage + " damage!");
                }
                break;

            case "Crimson Vortex":
                if (currentItem instanceof Components.NodeItem.Weapon) {
                    Components.NodeItem.Weapon weapon = (Components.NodeItem.Weapon) currentItem;
                    int damage = (int)((player.attackPlayer + weapon.power) * 1.2); // 20% bonus damage
                    monster.healthMonster -= damage;
                    System.out.println(player.namaPlayer + " unleashes Crimson Vortex for " + damage + " damage!");
                }
                break;

            // Armor
            case "Nightshade Plate":
                if (currentItem instanceof Components.NodeItem.Armor) {
                    Components.NodeItem.Armor armor = (Components.NodeItem.Armor) currentItem;
                    player.defensePlayer += armor.defense;
                    System.out.println(player.namaPlayer + " equips Nightshade Plate and gains " + armor.defense + " defense!");
                }
                break;

            case "Ironveil":
                if (currentItem instanceof Components.NodeItem.Armor) {
                    Components.NodeItem.Armor armor = (Components.NodeItem.Armor) currentItem;
                    player.defensePlayer += armor.defense;
                    System.out.println(player.namaPlayer + " equips Ironveil and gains " + armor.defense + " defense!");
                }
                break;

            // Potions
            case "Elixir of Shadows":
                if (currentItem instanceof Components.NodeItem.Potion) {
                    Components.NodeItem.Potion potion = (Components.NodeItem.Potion) currentItem;
                    player.attackPlayer += potion.attackAmount;
                    player.healthPlayer += potion.healingAmount;
                    System.out.println(player.namaPlayer + " drinks Elixir of Shadows and gains " + 
                                     potion.attackAmount + " attack and " + potion.healingAmount + " health!");
                }
                break;

            case "Lifeblood Brew":
                if (currentItem instanceof Components.NodeItem.Potion) {
                    Components.NodeItem.Potion potion = (Components.NodeItem.Potion) currentItem;
                    player.healthPlayer += potion.healingAmount;
                    System.out.println(player.namaPlayer + " drinks Lifeblood Brew and recovers " + 
                                     potion.healingAmount + " health!");
                }
                break;

            // Skills
            case "Blazing Strike":
                monster.healthMonster -= player.playerSkills.skill1.attackSkill1;
                System.out.println(player.namaPlayer + " uses Blazing Strike for " + player.playerSkills.skill1.attackSkill1 + " damage!");
                break;

            case "Mystic Barrier":
                player.defensePlayer += player.playerSkills.skill2.attackSkill2;
                System.out.println(player.namaPlayer + " uses Mystic Barrier and gains " + player.playerSkills.skill2.attackSkill2 + " defense!");
                break;

            case "Divine Restoration":
                player.healthPlayer += player.playerSkills.skill3.heal;
                System.out.println(player.namaPlayer + " uses Divine Restoration and heals for " + player.playerSkills.skill3.heal + " health!");
                break;


            default:
                System.out.println("Unknown action: " + action);
                break;
        }
    }
}