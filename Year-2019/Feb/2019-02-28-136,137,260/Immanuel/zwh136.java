class Solution {
    public int singleNumber(int[] nums) {
        int outPut = nums[0];
        for(int i = 1; i < nums.length; i++){
            outPut ^= nums[i];
        }
        return outPut;
    }
}