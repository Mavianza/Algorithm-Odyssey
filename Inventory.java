
public class Inventory {
    NodeInventory head;

    public Inventory() {
        head = null;
    }

    public void addItem(String itemName) {
        NodeInventory newItem = new NodeInventory(itemName);
        if (head == null) {
            head = newItem;
        } else {
            NodeInventory current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newItem;
        }
    }

    public void displayItems() {
        NodeInventory current = head;
        int index = 1;
        while (current != null) {
            System.out.println(index + ". " + current.itemName);
            current = current.next;
            index++;
        }
    }

    public String getItem(int index) {
        NodeInventory current = head;
        int count = 1;
        while (current != null) {
            if (count == index) {
                return current.itemName;
            }
            current = current.next;
            count++;
        }
        return null; // Jika tidak ada item pada index tersebut
    }
}