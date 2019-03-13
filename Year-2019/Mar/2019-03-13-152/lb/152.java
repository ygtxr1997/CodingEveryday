class Solution {
    /**
     * 多了一层反转的情况，需要记录最小值
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if (nums.length == 0)
            return 0;
        int max=1;
        int min=1;
        int ret=nums[0];
        int temp;
        for(int i =0;i<nums.length;i++){
            //小于零则会产生大变小，小变大的情况
            if (nums[i]<0){
                temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(max*nums[i],nums[i]);//记录中间产生的最大值，比较前n个数的乘积和当前数的大小，若小于说明该换区间了，发生在负数之后
            min = Math.min(min*nums[i],nums[i]);//伺机而动，等着翻身做主人
            ret = Math.max(max,ret);//整个过程中的最大值
        }
        return ret;
    }
}
