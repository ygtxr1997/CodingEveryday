class Solution {
//维护tails数组的方法
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        //Arrays.fill(tails, Integer.MIN_VALUE);
        int len = 0;
        for(int i = 0; i < nums.length; i++){
            int left = 0;
            int right = len;
            while (left < right){
                int middle = (left + right) / 2;
                if(nums[i] > tails[middle]){
                    left = middle + 1;
                }
                else 
                    right = middle;
            }
            tails[left] = nums[i];
            if(left == len) len++;
        }

        return len;
    }
    
//DP，时间复杂度为O(n^2)
//     public int lengthOfLIS(int[] nums) {
//         if(nums == null|| nums.length == 0)
//             return 0;
//         int outPut = 1;
        
//         int[] dp = new int[nums.length];
//         Arrays.fill(dp, 1);
//         for(int i = 1; i < nums.length; i++){
//             for(int j = 0; j < i; j++){
//                 if(nums[j] < nums[i]){
//                     dp[i] = Math.max(dp[i], dp[j] + 1);
//                 }
//             }
//             outPut = Math.max(outPut, dp[i]);
//         }
        
//         return outPut;
//     }
}