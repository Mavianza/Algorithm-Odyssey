public class NodeRoom {
    String roomName;
    Components.NodeMonster monster;
    NodeRoom left; 
    NodeRoom right; 

    public NodeRoom(String roomName, Components.NodeMonster monster) {
        this.roomName = roomName;
        this.monster = monster;
        this.left = null;
        this.right = null;
    }
}