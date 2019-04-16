class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] outPut = new int[nums.length];
        
        outPut[nums.length - 1] = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 1; i--){
            outPut[i] = outPut[i + 1] * nums[i];
        }
        outPut[0] = outPut[1];
        
        for(int i = 1; i < nums.length - 1; i++){
            outPut[i] = nums[i - 1] * outPut[i + 1]; 
            nums[i] *= nums[i - 1];
        }
        outPut[nums.length - 1] = nums[nums.length - 2];
        
        return outPut;
    }
}