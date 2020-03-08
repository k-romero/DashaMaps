public class Node {
    String theKey;
    Integer theValue;
    Node nextNode;

    public Node(String theKey, Integer theValue, Node nextNode) {
        this.theKey = theKey;
        this.theValue = theValue;
        this.nextNode = nextNode;
    }

    public Node() {
        this.theKey = "";
        this.theValue = 0;
        this.nextNode = null;
    }




    public Node createNewNode(String theKey, Integer theValue, Node nextNode){
        return new Node(theKey,theValue,nextNode);
    }
}
