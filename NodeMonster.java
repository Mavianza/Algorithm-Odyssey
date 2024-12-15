public class NodeMonster{
    String namaMonster;
    int healthMonster;
    int attackMonster;
    int defenseMonster;
    NodeMonster next = null;

    public NodeMonster(String namaMonster, int healthMonster, int damageMonster, int defenseMonster,int attackMonster) {
        this.namaMonster = namaMonster;
        this.healthMonster = healthMonster;
        this.attackMonster = attackMonster;
        this.defenseMonster = defenseMonster;
        this.next = null;
    }
}