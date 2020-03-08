public class DashaMapOne implements HashMapX{

    Node[] alphaNodes;

    public DashaMapOne() {
        this.alphaNodes = new Node[26];
        for (int i = 0; i < 26; i++) {
            String myString = "";
            char myChar = (char) (97 + i);
            myString += myChar;
            alphaNodes[i] = new Node(myString, null, null);
        }
    }

    public void set(String key, Integer value) {

    }

    public String delete(String key) {
        return null;
    }

    public String get(String key) {
        return null;
    }

    public boolean isEmpty() {
        return false;
    }

    public long size() {
        return 0;
    }

     public boolean bucketSize(String key) {
        return false;
    }

    public Node[] getAlphaNodes() {
        return alphaNodes;
    }

    //    public String HashFunctionOne(String input) {
//        if (input.length() > 0) {
//            return String.toLowerCase(String.valueOf(input.charAt(0)));
//        }
//        return null;
//    }
}
