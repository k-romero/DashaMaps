public class DashaMapOne extends DashaMap{

    public void set(String key, Integer value) {
        this.appendTo(hashFunctionOne(key), Node.createNewNode(key,value,null));
    }

    public String delete(String key) {
        for (Node n : alphaNodes) {
            if(n.theKey.equals(hashFunctionOne(key))){
                Node currentNode = n;
                for (int i = 0; i < n.theValue; i++) {
                    if(currentNode.nextNode.theKey.equals(key)){
                        currentNode.nextNode = currentNode.nextNode.nextNode;
                        n.theValue--;
                    } else {
                        currentNode = currentNode.nextNode;
                    }
                }
            }
        }
        return null;
    }

    public Integer get(String key) {
        return findIn(key).theValue;
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

    public Node findIn(String keyLetter) {
        for (Node n : alphaNodes) {
            if(n.theKey.equals(hashFunctionOne(keyLetter))){
                Node currentNode = n.nextNode;
                for (int i = 0; i < n.theValue; i++) {
                    if(currentNode.theKey.equalsIgnoreCase(keyLetter)){
                        return currentNode;
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

    public boolean bucketSize(String key) {
        return false;
    }

    public Node[] getAlphaNodes() {
        return alphaNodes;
    }


    public String hashFunctionOne(String input) {
        if (input.length() > 0) {
            return String.valueOf(input.charAt(0)).toLowerCase();
        }
        return null;
    }
}
