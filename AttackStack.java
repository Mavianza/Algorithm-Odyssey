public class AttackStack {
    private class StackNode {
        String attack;
        StackNode next;

        StackNode(String attack) {
            this.attack = attack;
            this.next = null;
        }
    }

    private StackNode top;

    public AttackStack() {
        top = null;
    }

    public void addAttack(String attack) {
        StackNode newNode = new StackNode(attack);
        newNode.next = top;
        top = newNode;
        System.out.println(attack + " has been added to the stack.");
    }

    public String useAttack() {
        if (top == null) {
            return null; // Jika stack kosong
        }
        String attack = top.attack;
        top = top.next;
        return attack;
    }
}