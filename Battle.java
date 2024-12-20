import java.util.Scanner;

class Battle {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static boolean fight(Components.NodePlayer player, Components.NodeMonster monster, Components.Skill Skillmanager, Linkedlist_item inventory) {
        Scanner scanner = new Scanner(System.in);
        Components.AttackStack attackStack = new Components.AttackStack();
        Components.BattleQueue turnQueue = new Components.BattleQueue();
        
        int initialDefense = player.defensePlayer;

        turnQueue.enqueue("player");
        turnQueue.enqueue("monster");
        
        while (player.healthPlayer > 0 && monster.healthMonster > 0) {
            String currentTurn = turnQueue.dequeue();
            System.out.println("\n=== Battle Status ===");
            System.out.println(player.namaPlayer + " Health: " + player.healthPlayer + " | Defense: " + player.defensePlayer);
            System.out.println(monster.namaMonster + " Health: " + monster.healthMonster + " | Attack: " + monster.attackMonster);
            if(currentTurn.equals("player")){
                System.out.println("\nChoose your action:");
                System.out.println("1. Add Attack to Stack");
                System.out.println("2. Add Skill to Stack");
                System.out.println("3. Add Item to Stack");
                System.out.println("4. Execute Actions from Stack");    
                int choice = scanner.nextInt();
                clearScreen();
                
                switch (choice) {
                    case 1:
                        System.out.println("Choose your weapon:");
                        System.out.println("1. Shadowfang (Base damage: 20)");
                        System.out.println("2. Crimson Vortex (Base damage: 25)");
                        int weaponChoice = scanner.nextInt();
                        clearScreen();
                        String weaponAction = weaponChoice == 1 ? "Shadowfang" : "Crimson Vortex";
                        attackStack.addAttack(weaponAction);
                        System.out.println(weaponAction + " added to action stack!");
                        break;
    
                    case 2:
                        System.out.println("Choose your skill:");
                        System.out.println("1. " + Skillmanager.skill1.namaPlayer + " (Damage: " + Skillmanager.skill1.attackSkill1 + ")");
                        System.out.println("2. " + Skillmanager.skill2.namaPlayer + " (Defense: " + Skillmanager.skill2.attackSkill2 + ")");
                        System.out.println("3. " + Skillmanager.skill3.namaPlayer + " (Heal: " + Skillmanager.skill3.heal + ")");
                        int skillChoice = scanner.nextInt();
                        clearScreen();
                        String skillAction = "";
                        switch (skillChoice) {
                            case 1: skillAction = "Blazing Strike"; break;
                            case 2: skillAction = "Mystic Barrier"; break;
                            case 3: skillAction = "Divine Restoration"; break;
                            default: continue;
                        }
                        attackStack.addAttack(skillAction);
                        System.out.println(skillAction + " added to action stack!");
                        break;
    
                    case 3:
                        System.out.println("Choose item type:");
                        System.out.println("1. Armor");
                        System.out.println("2. Potion");
                        int itemType = scanner.nextInt();
                        clearScreen();
                        
                        if (itemType == 1) {
                            System.out.println("Choose armor:");
                            System.out.println("1. Nightshade Plate (+15 defense)");
                            System.out.println("2. Ironveil (+20 defense)");
                            int armorChoice = scanner.nextInt();
                            clearScreen();
                            String armorAction = armorChoice == 1 ? "Nightshade Plate" : "Ironveil";
                            attackStack.addAttack(armorAction);
                            System.out.println(armorAction + " added to action stack!");
                        } else if (itemType == 2) {
                            System.out.println("Choose potion:");
                            System.out.println("1. Elixir of Shadows (+20 health, +10 attack)");
                            System.out.println("2. Lifeblood Brew (+40 health)");
                            int potionChoice = scanner.nextInt();
                            clearScreen();
                            String potionAction = potionChoice == 1 ? "Elixir of Shadows" : "Lifeblood Brew";
                            attackStack.addAttack(potionAction);
                            System.out.println(potionAction + " added to action stack!");
                        }
                        break;
    
                    case 4:
                        System.out.println("\nExecuting action stack!");
                        while (!attackStack.isEmpty()) {
                            String action = attackStack.useAttack();
                            executeAction(action, player, monster, inventory);
                            System.out.println("\nPress Enter to continue...");
                            scanner.nextLine();
                            scanner.nextLine();
                            clearScreen();
                        }
                        break;
    
                    default:
                        System.out.println("Invalid choice. Try again.");
                        continue;
                }
            }else{
                System.out.println("\n== Monster's Turn ==");
                monsterAttack(monster, player);
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
                scanner.nextLine();
                clearScreen();
            }
            turnQueue.enqueue(currentTurn);
        }

        // reset defense 
        player.defensePlayer = initialDefense;
        
        if (player.healthPlayer > 0) {
            clearScreen();
            System.out.println("\nVictory! " + player.namaPlayer + " has defeated " + monster.namaMonster);
            scanner.nextLine();
            scanner.nextLine();
            clearScreen();
            return true;
        } else {
            clearScreen();
            System.out.println("\nDefeat! " + player.namaPlayer + " has been defeated by " + monster.namaMonster);
            scanner.nextLine();
            scanner.nextLine();
            clearScreen();
            return false;
        }
    }

    private static void monsterAttack(Components.NodeMonster monster, Components.NodePlayer player) {
        if (monster.healthMonster > 0) {
            int rawDamage = monster.attackMonster;
            int reducedDamage = Math.max(0, rawDamage - player.defensePlayer);
            player.healthPlayer -= reducedDamage;
            System.out.println("\n" + monster.namaMonster + " counter-attacks!");
            System.out.println("Raw damage: " + rawDamage);
            System.out.println("Damage reduced by defense: " + player.defensePlayer);
            System.out.println("Final damage taken: " + reducedDamage);
            System.out.println("Player health remaining: " + player.healthPlayer);
        }
    }

    private static boolean executeAction(String action, Components.NodePlayer player, Components.NodeMonster monster, Linkedlist_item inventory) {
        boolean isAttackAction = false;
        
        switch (action) {
            case "Shadowfang":
                int shadowfangDamage = Math.max(0, 20 + player.attackPlayer - monster.defenseMonster);
                monster.healthMonster -= shadowfangDamage;
                System.out.println("Used Shadowfang!");
                System.out.println("Base damage: " + (20 + player.attackPlayer));
                System.out.println("Monster defense: " + monster.defenseMonster);
                System.out.println("Final damage dealt: " + shadowfangDamage);
                isAttackAction = true;
                break;

            case "Crimson Vortex":
                int vortexDamage = Math.max(0, (int)((25 + player.attackPlayer) * 1.2) - monster.defenseMonster);
                monster.healthMonster -= vortexDamage;
                System.out.println("Used Crimson Vortex!");
                System.out.println("Base damage: " + (int)((25 + player.attackPlayer) * 1.2));
                System.out.println("Monster defense: " + monster.defenseMonster);
                System.out.println("Final damage dealt: " + vortexDamage);
                isAttackAction = true;
                break;

            case "Nightshade Plate":
                int nightshadeDefense = 15;
                player.defensePlayer += nightshadeDefense;
                System.out.println("Equipped Nightshade Plate!");
                System.out.println("Defense increased by: " + nightshadeDefense);
                System.out.println("Current defense: " + player.defensePlayer);
                break;

            case "Ironveil":
                int ironveilDefense = 20;
                player.defensePlayer += ironveilDefense;
                System.out.println("Equipped Ironveil!");
                System.out.println("Defense increased by: " + ironveilDefense);
                System.out.println("Current defense: " + player.defensePlayer);
                break;

            case "Elixir of Shadows":
                player.healthPlayer += 20;
                player.attackPlayer += 10;
                System.out.println("Drank Elixir of Shadows!");
                System.out.println("Health recovered: 20");
                System.out.println("Attack increased by: 10");
                System.out.println("Current health: " + player.healthPlayer);
                System.out.println("Current attack: " + player.attackPlayer);
                break;

            case "Lifeblood Brew":
                player.healthPlayer += 40;
                System.out.println("Drank Lifeblood Brew!");
                System.out.println("Health recovered: 40");
                System.out.println("Current health: " + player.healthPlayer);
                break;

            case "Blazing Strike":
                int blazingDamage = Math.max(0, player.playerSkills.skill1.attackSkill1 - monster.defenseMonster);
                monster.healthMonster -= blazingDamage;
                System.out.println("Used Blazing Strike!");
                System.out.println("Base damage: " + player.playerSkills.skill1.attackSkill1);
                System.out.println("Monster defense: " + monster.defenseMonster);
                System.out.println("Final damage dealt: " + blazingDamage);
                isAttackAction = true;
                break;

            case "Mystic Barrier":
                int defenseGain = player.playerSkills.skill2.attackSkill2;
                player.defensePlayer += defenseGain;
                System.out.println("Used Mystic Barrier!");
                System.out.println("Defense increased by: " + defenseGain);
                System.out.println("Current defense: " + player.defensePlayer);
                break;

            case "Divine Restoration":
                int healAmount = player.playerSkills.skill3.heal;
                player.healthPlayer += healAmount;
                System.out.println("Used Divine Restoration!");
                System.out.println("Health recovered: " + healAmount);
                System.out.println("Current health: " + player.healthPlayer);
                break;

            default:
                System.out.println("Unknown action: " + action);
                break;
        }
        return isAttackAction;
    }
}