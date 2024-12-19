public class Linkedlist_monster {
    Components.NodeMonster head = null;
    Components.NodeMonster tail = null;
    void tambahData(Components.NodeMonster n){
        if(this.head==null){
            this.head = n;
            this.tail = head;
        } else{
            this.tail.next =n;
            this.tail = n;
        }
    }
}
