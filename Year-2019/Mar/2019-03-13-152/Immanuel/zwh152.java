class Solution {
    public int maxProduct(int[] nums) {
        int tmp = 1, outPut = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            tmp *= nums[i];
            outPut = Math.max(outPut, tmp);
            if(nums[i] == 0){
                tmp = 1;
            }
        }
        tmp = 1;
        for (int i = nums.length - 1; i >= 0; i--){
            tmp *= nums[i];
            outPut = Math.max(outPut, tmp);
            if(nums[i] == 0){
                tmp = 1;
            }
        }
        return outPut;
    }
}