public class NodeRoom {
    String roomName;
    Components.NodeMonster monster;
    NodeRoom left; // Ruangan kiri
    NodeRoom right; // Ruangan kanan

    public NodeRoom(String roomName, Components.NodeMonster monster) {
        this.roomName = roomName;
        this.monster = monster;
        this.left = null;
        this.right = null;
    }
}