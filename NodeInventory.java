public class NodeInventory {
    String itemName;
    NodeInventory next;

    public NodeInventory(String itemName) {
        this.itemName = itemName;
        this.next = null;
    }
}