class Solution {
    public void moveZeroes(int[] nums) {
      int i = 0;
        //定位第一个0的位置
        while(i<nums.length && nums[i]!=0)
            i++;
        //把非0的数字往前移
        for(int j = i;j<nums.length;j++){
            if (nums[j] == 0)
                continue;
            nums[i] = nums[j];
            i++;
        }
        //之后的数字置零
        for (;i<nums.length;i++)
            nums[i] = 0;
    }
}
