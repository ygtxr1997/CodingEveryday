class Solution {
    public int singleNumber(int[] nums) {
        int[] tmp = new int[32];
        for(int i = 0; i < nums.length; i++){
            int tmp_1 = nums[i];
            for(int j = 0; j < 32; j++){
                tmp[j] += tmp_1 & 1;
                tmp_1 >>= 1;
            }
        }
        int outPut = 0;
        for(int i = 0; i < 32; i++){
            tmp[i] %= 3;
            if(tmp[i] != 0){
                outPut += (1 << i);
            }
        }
        return outPut;
    }
}