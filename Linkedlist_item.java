public class Linkedlist_item {
    NodeItem head = null;
    NodeItem tail = null;
    void tambahData(NodeItem n){
        if(this.head==null){
            this.head = n;
            this.tail = head;
        } else{
            this.tail.next =n;
            this.tail = n;
        }
    }

    void displayItems() {
        NodeItem current = head;
        int index = 1;
        while (current != null) {
            System.out.println(index + ". " + current.namaItem);
            current = current.next;
            index++;
        }
    }
}
