public interface HashMapX {
    public void set(String key, Integer value);
    public String delete(String key);
    public Integer get(String key);
    public boolean isEmpty();
    public long size();
    public Node findIn(String keyLetter);
    public void appendTo(String keyHash, Node newVal);

    boolean bucketSize(String key); // used for tests
}
