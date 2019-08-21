class Solution {
    
    private void backtrace(List<List<Integer>> output, List<Integer> numList, List<Integer> tmpList){
        if(numList.size() == 0)
            output.add(new LinkedList<>(tmpList));
        
        for(int i = 0; i < numList.size(); i++){
            tmpList.add(numList.remove(i));
            backtrace(output, numList, tmpList);
            numList.add(i, tmpList.remove(tmpList.size() - 1));
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new LinkedList<>();
        if(nums == null || nums.length < 1)
            return output;
        
        List<Integer> numList = new LinkedList<>();
        for(int tmp: nums){
            numList.add(tmp);
        }
        backtrace(output, numList, new LinkedList<>());
        
        return output;
    }
    //插值法
//     private void insertValue(List<List<Integer>> ori, int value){
//         List<Integer> tmp = new ArrayList();
//         int size1 = ori.size();
//         for(int i = 0; i < size1; i++){
//             tmp = ori.remove(0);
//             for(int j = 0; j <= tmp.size(); j++){
//                 tmp.add(j, value);
//                 ori.add(new ArrayList(tmp));
//                 tmp.remove(j);
//             }
//         }
//     }
//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> per = new ArrayList();
//         if(nums.length == 0) return per;
//         List<Integer> tmp = new ArrayList();
//         tmp.add(nums[nums.length - 1]);
//         per.add(tmp);
//         for(int i = nums.length - 2; i >= 0; i--){
//             insertValue(per, nums[i]);
//         }

//         return per;
//     }
}