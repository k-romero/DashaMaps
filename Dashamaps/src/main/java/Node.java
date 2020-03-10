public class Node {
    String theKey;
    Integer theValue;
    Node nextNode;

    public Node(String theKey, Integer theValue, Node nextNode) {
        this.theKey = theKey;
        this.theValue = theValue;
        this.nextNode = nextNode;
    }

    //necessary for node builder

    public Node() {
        this.theKey = "";
        this.theValue = 0;
        this.nextNode = null;
    }


    public static Node createNewNode(String theKey, Integer theValue, Node nextNode){
        return new Node(theKey,theValue,nextNode);
    }
}
