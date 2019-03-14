class Solution {
    /**
     * 学习一个内置函数
     * System.arraycopy(tmp,tmp.length-k,nums,0,k)
     * 把temp中序号为length-k起的k个数复制到num中序号为0起的k个数
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        int left = length-k;
        int[] temp = new int[left];
        //备份前length - k 个数
        for (int i = 0;i<left;i++){
            temp[i] = nums[i];
        }
        //旋转后面k个数
        for(int i = left;i<length;i++){
            nums[i-left] = nums[i];
        }
        //填入前k个数
        for (int i=k;i<length;i++){
            nums[i] = temp[i-k];
        }
//        k=k%nums.length;
//        int[] tmp=nums.clone();
//        System.arraycopy(tmp,tmp.length-k,nums,0,k);
//        System.arraycopy(tmp,0,nums,k,tmp.length-k);
    }
}
