public class BattleQueue {
    class Node {
        Components.NodePlayer player;
        Components.NodeMonster monster;
        Node next;

        Node(Components.NodePlayer player, Components.NodeMonster monster) {
            this.player = player;
            this.monster = monster;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public BattleQueue() {
        head = null;
        tail = null;
    }

    public void add(Components.NodePlayer player, Components.NodeMonster monster) {
        Node newNode = new Node(player, monster);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public Node getNext() {
        if (head == null) {
            return null;
        }
        Node nextNode = head;
        head = head.next;
        return nextNode;
    }
}