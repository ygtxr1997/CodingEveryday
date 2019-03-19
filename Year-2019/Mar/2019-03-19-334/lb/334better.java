class Solution {
//只使用两个参数记录前两位数
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE,second = Integer.MAX_VALUE;
        if(nums.length<3){
            return false;
        }
        for(int num:nums){
            if(first>num){
                first = num;
            }else if(first<num && second>num){
                second = num;
            }else if(num>second){
                return true;
            }
        }
        return false;
    }
}
