class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length < 1)
            return nums.length;
        
        int outPut = Integer.MIN_VALUE;
        int len = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i - 1]){
                len++;
            }
            else{
                outPut = Math.max(outPut, len);
                len = 1;
            }
        }
        
        return Math.max(outPut, len);
    }
}