public class NodePlayer{
    String namaPlayer;
    String skillPlayer;
    int healthPlayer;
    int attackPlayer;
    int defensePlayer;
    NodePlayer next = null;
    public NodePlayer(String namaPlayer, int healthPlayer, int attackPlayer, int defensePlayer) {
        this.namaPlayer = namaPlayer;
        this.skillPlayer = skillPlayer;
        this.healthPlayer = healthPlayer;
        this.attackPlayer = attackPlayer;
        this.defensePlayer = defensePlayer;
        this.next = null;
    }
}