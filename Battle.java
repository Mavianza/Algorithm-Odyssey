public class Battle {
    public static void fight(NodePlayer player, NodeMonster monster) {
        while (player.healthPlayer > 0 && monster.healthMonster > 0) {
            // Hitung damage yang diterima monster
            int damageToMonster = player.attackPlayer - monster.defenseMonster;
            if (damageToMonster > 0) {
                monster.healthMonster -= damageToMonster;
            }

            // Hitung damage yang diterima pemain
            int damageToPlayer = monster.attackMonster - player.defensePlayer;
            if (damageToPlayer > 0) {
                player.healthPlayer -= damageToPlayer;
            }
        }

        if (player.healthPlayer > 0) {
            System.out.println(player.namaPlayer + " has defeated " + monster.namaMonster);
        } else {
            System.out.println(player.namaPlayer + " has been defeated by " + monster.namaMonster);
        }
    }
}