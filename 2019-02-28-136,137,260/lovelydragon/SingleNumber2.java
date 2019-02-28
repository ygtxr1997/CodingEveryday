class Solution {
    public int singleNumber(int[] nums) {
       int[] bytes = new int[32];
        for(int i =0;i<nums.length;i++){
            for(int j=0;j<32;j++){
                bytes[j] += (nums[i]&(1<<j))>>j;
            }
        }
        int ret = 0;
        for(int i=0;i<32;i++){
            ret |= (bytes[i] % 3) << i;
        }
        return ret;
    }
}
