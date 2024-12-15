public class Main {
    public static void main(String[] args) {
        Linkedlist_item item = new Linkedlist_item();
        //setiap level itemnya berbeda untuk player;
        NodePlayer dael = new NodePlayer("dael", 0, 0, 0);
        NodeItem Playerlevel_1 = new NodeItem("bero", 0, null);
        NodeItem.Potion healing = Playerlevel_1.new Potion("healing", 0, false, 0, 0);

        //Menambahkan semua level ke dalam linkedlist
        item.tambahData(Playerlevel_1);
        // item.tambahData(Playerlevel_2);
        // item.tambahData(Playerlevel_3);
        // item.tambahData(Playerlevel_4);
        // item.tambahData(Playerlevel_5);
        // item.tambahData(Playerlevel_6);


        // item.tambahData(Monsterlevel_1);
        // item.tambahData(Monsterlevel_2);
        // item.tambahData(Monsterlevel_3);
        // item.tambahData(Monsterlevel_4);
        // item.tambahData(Monsterlevel_5);
        // item.tambahData(Monsterlevel_6);

    }
    
}
