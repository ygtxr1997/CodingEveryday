public class Solution{
    
    public int longestConsecutive(int[] nums) {
         if(nums.length < 2)
             return nums.length;

         int outPut = Integer.MIN_VALUE;
         Map<Integer, Integer> map = new HashMap<>();
         for(int i = 0; i < nums.length; i++){
             int tmp = nums[i];
             if(!map.containsKey(tmp)){
                 int left = map.getOrDefault(tmp - 1, 0);
                 int right = map.getOrDefault(tmp + 1, 0);
                 int len = left + right + 1;
                 outPut = Math.max(outPut, len);
                 map.put(tmp, len);
                 map.put(tmp - left, len);
                 map.put(tmp + right, len);
             }
         }

         return outPut;
     }

//要个锤子O(n)，Arrays.sort就完事了
    // public int longestConsecutive(int[] nums) {
    //     if(nums.length < 2)
    //         return nums.length;
    //     Arrays.sort(nums);
    //     int outPut = 1;
    //     int tmp = 1;
    //     for(int i = 1; i < nums.length; i++){
    //         if(nums[i] - nums[i - 1] == 1){
    //             tmp++;
    //         }
    //         else if(nums[i] - nums[i - 1] == 0){
    //             ;
    //         }
    //         else{
    //             outPut = Math.max(outPut, tmp);
    //             tmp = 1;
    //         }
    //     }
    //     outPut = Math.max(outPut, tmp);
    //     return outPut;
    // }
}