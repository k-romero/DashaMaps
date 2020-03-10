public abstract class DashaMap implements HashMapX{

    Node nodeBuilder = new Node();
    Node[] alphaNodes;

    public DashaMap() {
        this.alphaNodes = new Node[26];
        for (int i = 0; i < 26; i++) {
            String myString = "";
            char myChar = (char) (97 + i);
            myString += myChar;
            alphaNodes[i] = Node.createNewNode(myString,0,null);
        }
    }

    public boolean isEmpty() {
        for (Node n : alphaNodes) {
            if(n.theValue > 0){
                return false;
            }
        }
        return true;
    }

    public long size() {
        long result = 0l;
        for (Node n :alphaNodes) {
            result += n.theValue;
        }
        return result;
    }

    public boolean bucketSize(String key) {
        return false;
    }

    public Node[] getAlphaNodes() {
        return alphaNodes;
    }

    public void appendTo(String keyHash, Node newVal){
        for (Node n: alphaNodes) {
            if(keyHash.equals(n.theKey)){
                if(n.nextNode == null){
                    n.nextNode = newVal;
                    n.theValue++;
                    break;
                } else {
                    Node tempNode = n.nextNode;
                    for (int i = 0; i < n.theValue; i++) {
                        if(tempNode.nextNode == null){
                            tempNode.nextNode = newVal;
                            n.theValue++;
                        }
                        else{
                            tempNode = tempNode.nextNode;
                        }
                    }
                }
            }
        }
    }

}


