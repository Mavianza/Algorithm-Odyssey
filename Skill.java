public class Skill {
    //skill dari extends node player
    NodePlayer skill = new NodePlayer("dael", 0, 0, 0);
    //skill 1
    skillSatu skill1 = new skillSatu("Blazing Strike", 0, 69, 0, 0);
    //skill 2
    skillDua skill2 = new skillDua("Mystic Barrier", 0, 100, 0, 0);
    //skill 3
    skillTiga skill3 = new skillTiga("Divine Restoration", 911, 0, 0, 0);  
    
    public Skill(NodePlayer player) {
        this.skill = player;
    }

    public void tambahSkill(int skillChoice) {
        switch (skillChoice) {
            case 1: // Tambah Skill 1
                skill.attackPlayer += skill1.attackSkill1;
                System.out.println(skill.namaPlayer + " menggunakan " + skill1.namaPlayer + "! Attack meningkat sebesar " + skill1.attackSkill1);
                break;
            case 2: // Tambah Skill 2
                skill.defensePlayer += skill2.attackSkill2;
                System.out.println(skill.namaPlayer + " menggunakan " + skill2.namaPlayer + "! Defense meningkat sebesar " + skill2.attackSkill2);
                break;
            case 3: // Tambah Skill 3
                skill.healthPlayer += skill3.heal;
                System.out.println(skill.namaPlayer + " menggunakan " + skill3.namaPlayer + "! Health bertambah sebesar " + skill3.heal);
                break;
            default:
                System.out.println("Pilihan skill tidak valid.");
        }
    }
    
}
