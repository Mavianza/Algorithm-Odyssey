public class NodePlayer{
    String namaPlayer;
    int healthPlayer;
    int attackPlayer;
    int defensePlayer;
    NodePlayer next = null;
    public NodePlayer(String namaPlayer, int healthPlayer, int attackPlayer, int defensePlayer) {
        this.namaPlayer = namaPlayer;
        this.healthPlayer = healthPlayer;
        this.attackPlayer = attackPlayer;
        this.defensePlayer = defensePlayer;
        this.next = null;
    }
    
    class skillSatu extends NodePlayer{
        int attackSkill1;
        public skillSatu(String namaPlayer, int healthPlayer, int attackPlayer, int defensePlayer, int attackSkill1){
            super(namaPlayer, healthPlayer, attackPlayer, defensePlayer);
            this.attackSkill1 = attackSkill1;
        }
    }
    class skillDua extends NodePlayer{
        int attackSkill2;
        public skillDua(String namaPlayer, int healthPlayer, int attackPlayer, int defensePlayer, int attackSkill2){
            super(namaPlayer, healthPlayer, attackPlayer, defensePlayer);
            this.attackSkill2 = attackSkill2;
        }
    }
    class skillTiga extends NodePlayer{
        int heal;
        public skillTiga(String namaPlayer, int healthPlayer, int attackPlayer, int defensePlayer, int heal){
            super(namaPlayer, healthPlayer, attackPlayer, defensePlayer);
            this.heal = heal;
        }
    }
}