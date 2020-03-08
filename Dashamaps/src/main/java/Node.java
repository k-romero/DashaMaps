public class Node {
    String theKey;
    Integer theValue;
    Node nextNode;

    public Node(String theKey, Integer theValue, Node nextNode) {
        this.theKey = theKey;
        this.theValue = theValue;
        this.nextNode = nextNode;
    }
}
