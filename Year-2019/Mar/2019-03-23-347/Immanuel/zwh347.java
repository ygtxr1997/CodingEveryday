class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(map.size(), (x1, x2) -> {
            return x2.getValue() - x1.getValue();
        });
        heap.addAll(map.entrySet());
        
        List<Integer> outPut = new ArrayList<>();
        while (outPut.size() < k){
            outPut.add(heap.poll().getKey());
        }

        return outPut;
    }
}