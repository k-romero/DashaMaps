public class DashaMapTwo extends DashaMap{

    public String hashFunctionTwo(String input) {
        if(input.length() == 1){
            return String.valueOf(input.charAt(0)).toLowerCase();
        }
        else if (input.length() > 0) {
            return String.valueOf(input.charAt(1)).toLowerCase();
        }
        return null;
    }

    public void set(String key, Integer value) {
        appendTo(hashFunctionTwo(key),nodeBuilder.createNewNode(key,value,null));
    }

    public String delete(String key) {
        return null;
    }

    public Integer get(String key) {
        return findIn(key).theValue;
    }

    public Node findIn(String keyLetter) {
        for (Node n : alphaNodes) {
            if(n.theKey.equals(hashFunctionTwo(keyLetter))){
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
}
