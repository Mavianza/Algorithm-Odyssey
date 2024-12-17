import java.util.Scanner;

public class Battle {
    public static void fight(NodePlayer player, NodeMonster monster) {
        Scanner scanner = new Scanner(System.in);
        AttackStack attackStack = new AttackStack();

        while (player.healthPlayer > 0 && monster.healthMonster > 0) {
            // Tampilkan status kesehatan
            System.out.println(player.namaPlayer + " Health: " + player.healthPlayer);
            System.out.println(monster.namaMonster + " Health: " + monster.healthMonster);
            
            // Pilihan aksi
            System.out.println("Choose your action:");
            System.out.println("1. Attack");
            System.out.println("2. Use Skill");
            System.out.println("3. Use Item");
            System.out.println("4. Execute Actions from Stack");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Pilih senjata
                    System.out.println("Choose your weapon:");
                    System.out.println("1. Shadowfang");
                    // Tambahkan lebih banyak senjata jika ada
                    int weaponChoice = scanner.nextInt();
                    String attackAction = "Attack with Shadowfang"; // Ganti dengan logika senjata jika ada
                    attackStack.addAttack(attackAction);
                    break;

                case 2:
                    // Pilih skill
                    System.out.println("Choose your skill:");
                    System.out.println("1. Fireball");
                    // Tambahkan lebih banyak skill jika ada
                    int skillChoice = scanner.nextInt();
                    String skillAction = "Use Fireball"; // Ganti dengan logika skill jika ada
                    attackStack.addAttack(skillAction);
                    break;

                case 3:
                    // Pilih item
                    System.out.println("Choose your item:");
                    System.out.println("1. Health Potion");
                    // Tambahkan lebih banyak item jika ada
                    int itemChoice = scanner.nextInt();
                    String itemAction = "Use Health Potion"; // Ganti dengan logika item jika ada
                    attackStack.addAttack(itemAction);
                    break;

                case 4:
                    // Eksekusi semua aksi dari stack
                    while (true) {
                        String action = attackStack.useAttack();
                        if (action == null) {
                            break; // Jika stack kosong, keluar dari loop
                        }
                        executeAction(action, player, monster);
                    }
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
                    continue; // Kembali ke awal loop jika pilihan tidak valid
            }

            // Monster menyerang
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

        if (player.healthPlayer > 0) {
            System.out.println(player.namaPlayer + " has defeated " + monster.namaMonster);
        } else {
            System.out.println(player.namaPlayer + " has been defeated by " + monster.namaMonster);
        }
    }

    private static void executeAction(String action, NodePlayer player, NodeMonster monster) {
        switch (action) {
            case "Attack with Shadowfang":
                int damageToMonster = player.attackPlayer; // Ganti dengan logika senjata jika ada
                monster.healthMonster -= damageToMonster;
                System.out.println(player.namaPlayer + " attacks " + monster.namaMonster + " for " + damageToMonster + " damage.");
                break;

            // case "Use Fireball":
            //     int skillDamage = 10; // Ganti dengan logika skill jika ada
            //     monster.healthMonster -= skillDamage;
            //     System.out.println(player.namaPlayer + " uses Fireball on " + monster.namaMonster + " for " + skillDamage + " damage.");
            //     break;

            // case "Use Health Potion":
            //     int healAmount = 20; // Ganti dengan logika item jika ada
            //     player.health Player += healAmount;
            //     System.out.println(player.namaPlayer + " uses Health Potion and heals for " + healAmount + " health.");
            //     break;

            default:
                System.out.println("Unknown action.");
                break;
        }
    }
}