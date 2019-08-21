class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> sets = new LinkedList<>();
        if(nums == null || nums.length < 1)
            return sets;

        sets.add(new LinkedList<>());
        for(int tmp: nums){
            int count = sets.size();
            while (count-- > 0){
                List<Integer> tmpSet = new LinkedList<>(sets.get(count));
                tmpSet.add(tmp);
                sets.add(tmpSet);
            }
        }
        return sets;
    }
}