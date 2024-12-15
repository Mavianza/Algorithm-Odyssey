public class Main {
    public static void main(String[] args) {
        Linkedlist_item item = new Linkedlist_item();
        //setiap level itemnya berbeda untuk player
        NodeItem Playerlevel_1 = new NodeItem(null, 0, null, 0, null, 0, null);
        NodeItem Playerlevel_2 = new NodeItem(null, 0, null, 0, null, 0, null);
        NodeItem Playerlevel_3 = new NodeItem(null, 0, null, 0, null, 0, null);
        NodeItem Playerlevel_4 = new NodeItem(null, 0, null, 0, null, 0, null);
        NodeItem Playerlevel_5 = new NodeItem(null, 0, null, 0, null, 0, null);
        NodeItem Playerlevel_6 = new NodeItem(null, 0, null, 0, null, 0, null);
        
        //untuk monster
        NodeItem Monsterlevel_1 = new NodeItem(null, 0, null, 0, null, 0, null);
        NodeItem Monsterlevel_2 = new NodeItem(null, 0, null, 0, null, 0, null);
        NodeItem Monsterlevel_3 = new NodeItem(null, 0, null, 0, null, 0, null);
        NodeItem Monsterlevel_4 = new NodeItem(null, 0, null, 0, null, 0, null);
        NodeItem Monsterlevel_5 = new NodeItem(null, 0, null, 0, null, 0, null);
        NodeItem Monsterlevel_6 = new NodeItem(null, 0, null, 0, null, 0, null);

        //Menambahkan semua level ke dalam linkedlist
        item.tambahData(Playerlevel_1);
        item.tambahData(Playerlevel_2);
        item.tambahData(Playerlevel_3);
        item.tambahData(Playerlevel_4);
        item.tambahData(Playerlevel_5);
        item.tambahData(Playerlevel_6);


        item.tambahData(Monsterlevel_1);
        item.tambahData(Monsterlevel_2);
        item.tambahData(Monsterlevel_3);
        item.tambahData(Monsterlevel_4);
        item.tambahData(Monsterlevel_5);
        item.tambahData(Monsterlevel_6);

    }
    
}
