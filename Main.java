public class Main {
    public static void main(String[] args) {
        Linkedlist_item item = new Linkedlist_item();
        //setiap level itemnya berbeda
        NodeItem level_1 = new NodeItem(null, 0, null, 0, null, 0, null);
        NodeItem level_2 = new NodeItem(null, 0, null, 0, null, 0, null);
        NodeItem level_3 = new NodeItem(null, 0, null, 0, null, 0, null);
        NodeItem level_4 = new NodeItem(null, 0, null, 0, null, 0, null);
        NodeItem level_5 = new NodeItem(null, 0, null, 0, null, 0, null);
        NodeItem level_6 = new NodeItem(null, 0, null, 0, null, 0, null);

        //Menambahkan semua level ke dalam linkedlist
        item.tambahData(level_1);
        item.tambahData(level_2);
        item.tambahData(level_3);
        item.tambahData(level_4);
        item.tambahData(level_5);
        item.tambahData(level_6);

    }
    
}
