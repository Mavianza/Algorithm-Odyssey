public class NodePlayer {
    String namaPlayer;
    int healthPlayer;
    int attackPlayer;
    int defensePlayer;
    Inventory inventory; // Menyimpan senjata, skill, dan item

    public NodePlayer(String namaPlayer, int healthPlayer, int attackPlayer, int defensePlayer) {
        this.namaPlayer = namaPlayer;
        this.healthPlayer = healthPlayer;
        this.attackPlayer = attackPlayer;
        this.defensePlayer = defensePlayer;
        this.inventory = new Inventory();
        
        // Menambahkan beberapa item ke inventory untuk contoh
        inventory.addItem("Shadowfang"); // Senjata
        inventory.addItem("Fireball"); // Skill
        inventory.addItem("Health Potion"); // Item
    }
}
    
    class skillSatu extends NodePlayer{
        int attackSkill1;
        public skillSatu(String namaSkill, int healthPlayer, int attackPlayer, int defensePlayer, int attackSkill1){
            super(namaSkill, healthPlayer, attackPlayer, defensePlayer);
            this.attackSkill1 = attackSkill1;
        }
    }
    class skillDua extends NodePlayer{
        int attackSkill2;
        public skillDua(String namaSkill, int healthPlayer, int attackPlayer, int defensePlayer, int attackSkill2){
            super(namaSkill, healthPlayer, attackPlayer, defensePlayer);
            this.attackSkill2 = attackSkill2;
        }
    }
    class skillTiga extends NodePlayer{
        int heal;
        public skillTiga(String namaSkill, int healthPlayer, int attackPlayer, int defensePlayer, int heal){
            super(namaSkill, healthPlayer, attackPlayer, defensePlayer);
            this.heal = heal;
        }
    }
