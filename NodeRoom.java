public class NodeRoom {
    String roomName;
    NodeMonster monster;
    NodeRoom left; // Ruangan kiri
    NodeRoom right; // Ruangan kanan

    public NodeRoom(String roomName, NodeMonster monster) {
        this.roomName = roomName;
        this.monster = monster;
        this.left = null;
        this.right = null;
    }
}