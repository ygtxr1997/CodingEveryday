class Solution {
    public int[] singleNumber(int[] nums) {
        int[] outPut = {0, 0};
        int xor = nums[0];
        for(int i = 1; i < nums.length; i++){
            xor ^= nums[i];
        }
        xor &= -xor;
        for(int i = 0; i < nums.length; i++){
            if((nums[i] & xor) == 0){
                outPut[0] ^= nums[i];
            } 
            else{
                
                outPut[1] ^= nums[i];
                
            }
        }
        
        
        return outPut;
    }
}