public class Linkedlist_item {
    Components.NodeItem head = null;
    Components.NodeItem tail = null;
    void tambahData(Components.NodeItem n){
        if(this.head==null){
            this.head = n;
            this.tail = head;
        } else{
            this.tail.next =n;
            this.tail = n;
        }
    }

    void displayItems() {
        Components.NodeItem current = head;
        int index = 1;
        while (current != null) {
            System.out.println(index + ". " + current.namaItem);
            current = current.next;
            index++;
        }
    }
}
