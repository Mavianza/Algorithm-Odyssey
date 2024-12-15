public class Main {
    public static void main(String[] args) {
        Linkedlist_item item = new Linkedlist_item();
        //setiap level itemnya berbeda untuk player
        NodeItem Playerlevel_1 = new NodeItem(null, 0, false);
        NodeItem Playerlevel_2 = new NodeItem(null, 0, false);
        NodeItem Playerlevel_3 = new NodeItem(null, 0, false);
        NodeItem Playerlevel_4 = new NodeItem(null, 0, false);
        NodeItem Playerlevel_5 = new NodeItem(null, 0, false);
        NodeItem Playerlevel_6 = new NodeItem(null, 0, false);

        //Menambahkan semua level ke dalam linkedlist
        item.tambahData(Playerlevel_1);
        item.tambahData(Playerlevel_2);
        item.tambahData(Playerlevel_3);
        item.tambahData(Playerlevel_4);
        item.tambahData(Playerlevel_5);
        item.tambahData(Playerlevel_6);
    }
    
}
