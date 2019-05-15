public class Solution{
    //对数组进行排序，然后将前半段倒序填入奇数下标，将后半段倒序填入偶数下标
    public void wiggleSort(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int j = (nums.length-1) / 2;
        for(int i = 0; i < nums.length; i += 2){
            nums[i] = sorted[j--];
        }
        j = nums.length - 1;
        for(int i = 1; i < nums.length; i += 2){
            nums[i] = sorted[j--];
        }
        //在某博客上看到的不知所云的东西，其介绍：先对数组进行排序, 然后从左往右奇数索引位置放大于中位数的数, 然后从右往左在偶数索引位置放小于中位数的数, 剩下的位置都放中位数
        //你从左往右你妈呢
        // j = (nums.length + 1) / 2;
        // for(int i = 1; i < nums.length; i += 2){
        //     nums[i] = sorted[j++];
        // }
    }
}