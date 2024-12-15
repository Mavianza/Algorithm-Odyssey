public class Linkedlist_monster {
    NodeMonster head = null;
    NodeMonster tail = null;
    void tambahData(NodeMonster n){
        if(this.head==null){
            this.head = n;
            this.tail = head;
        } else{
            this.tail.next =n;
            this.tail = n;
        }
    }
}
