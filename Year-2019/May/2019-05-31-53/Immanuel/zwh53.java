public class Solution {
    public int maxSubArray(int[] nums) {
        int outPut = Integer.MIN_VALUE;
        
        int sum = 0;
        for(int tmp: nums){
            if(tmp >= 0){
                sum += tmp;
                outPut = Math.max(outPut, sum);
            }
            else {
                if (sum + tmp <= 0){
                    outPut = Math.max(outPut, tmp);
                    sum = 0;
                }
                else
                    sum += tmp;
            }
        }
        
        return outPut;
    }
}