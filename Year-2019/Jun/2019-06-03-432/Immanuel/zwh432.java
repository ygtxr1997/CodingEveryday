//垃圾方法，runtime 73ms，beats 9.58%，打扰了

class AllOne {
    class Pair{
        String key;
        int value;
        public Pair(String key, int value){
            this.key = new String(key);
            this.value = value;
        }
    }
    Map<String, Integer> elements;
    PriorityQueue<Pair> maxHeap;
    PriorityQueue<Pair> minHeap;
    /** Initialize your data structure here. */
    public AllOne() {
        elements = new HashMap<>();
        elements = new TreeMap<>();
        maxHeap = new PriorityQueue<>((x1, x2) -> {
            return x2.value - x1.value;
        });
        minHeap = new PriorityQueue<>((x1, x2) -> {
            return x1.value - x2.value;
        });
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        elements.put(key, elements.getOrDefault(key, 0) + 1);
        maxHeap.add(new Pair(key, elements.get(key)));
        minHeap.add(new Pair(key, elements.get(key)));
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(elements.getOrDefault(key, 0) < 2){
            elements.remove(key);
        }
        else {
            elements.put(key, elements.get(key) - 1);
            maxHeap.add(new Pair(key, elements.get(key)));
            minHeap.add(new Pair(key, elements.get(key)));
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        while (!maxHeap.isEmpty()&& maxHeap.peek().value != elements.getOrDefault(maxHeap.peek().key, 0)){
            maxHeap.poll();
        }
        return maxHeap.isEmpty()? "": maxHeap.peek().key;
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        while (!minHeap.isEmpty()&& minHeap.peek().value != elements.getOrDefault(minHeap.peek().key, 0)){
            minHeap.poll();
        }
        return minHeap.isEmpty()? "": minHeap.peek().key;
    }
}


// class AllOne {
//     Map<String, Integer> elements;
//     PriorityQueue<Map.Entry> maxHeap;
//     PriorityQueue<Map.Entry> minHeap;
//     /** Initialize your data structure here. */
//     public AllOne() {
//         elements = new HashMap<>();
//         elements = new TreeMap<>();
//         maxHeap = new PriorityQueue<>((x1, x2) -> {
//             return (Integer)x2.getValue() - (Integer)x1.getValue();
//         });
//         minHeap = new PriorityQueue<>((x1, x2) -> {
//             return (Integer)x1.getValue() - (Integer)x2.getValue();
//         });
//     }

//     /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
//     public void inc(String key) {
//         elements.put(key, elements.getOrDefault(key, 0) + 1);
//         maxHeap.add(new java.util.AbstractMap.SimpleEntry(key, elements.get(key)));
//         minHeap.add(new java.util.AbstractMap.SimpleEntry(key, elements.get(key)));
//     }

//     /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
//     public void dec(String key) {
//         if(elements.getOrDefault(key, 0) < 2){
//             elements.remove(key);
//         }
//         else {
//             elements.put(key, elements.get(key) - 1);
//             maxHeap.add(new java.util.AbstractMap.SimpleEntry(key, elements.get(key)));
//             minHeap.add(new java.util.AbstractMap.SimpleEntry(key, elements.get(key)));
//         }
//     }

//     /** Returns one of the keys with maximal value. */
//     public String getMaxKey() {
//         while (!maxHeap.isEmpty()&& maxHeap.peek().getValue() != elements.get(maxHeap.peek().getKey())){
//             maxHeap.poll();
//         }
//         return maxHeap.isEmpty()? "": (String) maxHeap.peek().getKey(); 
//     }

//     /** Returns one of the keys with Minimal value. */
//     public String getMinKey() {
//         while (!minHeap.isEmpty()&& minHeap.peek().getValue() != elements.get(minHeap.peek().getKey())){
//             minHeap.poll();
//         }
//         return minHeap.isEmpty()? "": (String) minHeap.peek().getKey();
//     }
// }