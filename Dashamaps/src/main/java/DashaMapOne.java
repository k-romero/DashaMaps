public class DashaMapOne implements HashMapX{
    Node nodeBuilder = new Node();
    Node[] alphaNodes;

    public DashaMapOne() {
        this.alphaNodes = new Node[26];
        for (int i = 0; i < 26; i++) {
            String myString = "";
            char myChar = (char) (97 + i);
            myString += myChar;
            alphaNodes[i] = new Node(myString, 0, null);
        }
    }

    public void set(String key, Integer value) {
        this.appendTo(hashFunctionOne(key),nodeBuilder.createNewNode(key,value,null));
    }

    public String delete(String key) {
        return null;
    }

    public Integer get(String key) {
        for (Node n : alphaNodes) {
            if(n.theKey.equals(hashFunctionOne(key))){
                Node currentNode = n.nextNode;
                for (int i = 0; i < n.theValue; i++) {
                    if(currentNode.theKey.equalsIgnoreCase(key)){
                        return currentNode.theValue;
                    } else if(currentNode.nextNode == null){
                        break;
                    } else {
                        currentNode = currentNode.nextNode;
                    }
                }
            }
        }
        return null;
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

    public String hashFunctionOne(String input) {
        if (input.length() > 0) {
            return String.valueOf(input.charAt(0)).toLowerCase();
        }
        return null;
    }
}
