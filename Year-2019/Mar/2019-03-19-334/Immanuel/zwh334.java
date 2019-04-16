class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3)
            return false;

        int top = Integer.MAX_VALUE;
        int buttom = Integer.MAX_VALUE;
        int pos = 1;
        while (pos < nums.length){
            while (pos < nums.length){
                if(nums[pos] > nums[pos - 1]){
                    if(nums[pos] > top|| nums[pos - 1] > buttom){
                        return true;
                    }
                    else {
                        buttom = Math.min(buttom, nums[pos - 1]);
                        top = nums[pos];
                        pos++;
                        break;
                    }
                }
                pos++;
            }
        }

        return false;
    }
}