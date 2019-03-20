class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ret = new int[nums.length];
        int product = 1;
        //计算num[i]左边数的乘积
        for (int i =0;i<nums.length;i++){
            ret[i] = product;
            product *= nums[i];
        }
        product = 1;
        //计算nums[i]右边数的乘积并计算最终的结果
        for (int i = nums.length-1 ;i>=0;i--){
            ret[i] *= product;
            product *= nums[i];
        }
        return  ret;
    }
}
