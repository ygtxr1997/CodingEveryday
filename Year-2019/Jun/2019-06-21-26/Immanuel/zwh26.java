class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 2)
            return nums.length;

        int len = 1;
        int tmp = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != tmp){
                nums[len++] = tmp = nums[i];
            }
        }
        return len;
    }
    //减少了变量引入
    // public int removeDuplicates(int[] nums) {
    //     int i = 0;
    //     for (int n : nums)
    //         if (i == 0 || n > nums[i-1])
    //             nums[i++] = n;
    //     return i;
    // }
}