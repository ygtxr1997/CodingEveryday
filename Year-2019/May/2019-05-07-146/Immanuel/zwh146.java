class LRUCache {

    private LinkedHashMap<Integer, Integer> cache;
    private int CAPACITY;

    public LRUCache(int capacity) {
        CAPACITY = capacity;
        cache = new LinkedHashMap<Integer, Integer>(CAPACITY, 0.75f, true){
            protected boolean removeEldestEntry(Map.Entry eldest){
                return size() > CAPACITY;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */