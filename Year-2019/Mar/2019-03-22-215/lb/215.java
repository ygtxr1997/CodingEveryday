public class FindKthLargest {
    //堆排序
    public int findKthLargest(int[] nums, int k) {
        for (int i = nums.length/2-1;i>=0;i--)
            ajustHead(nums,i,nums.length);
        for (int i = nums.length-1;i>=nums.length-k;i--){
            swap(nums,0,i);
            ajustHead(nums,0,i);
        }
        return nums[nums.length-k];
    }

    public void ajustHead(int[] nums,int i,int length){
        for (int j = 2*i+1;j<length;j=2*j+1){
            if(j+1<length && nums[j+1]>nums[j])
                j++;
            if (nums[j]>nums[i]){
                swap(nums,i,j);
                i = j;
            }else{
                break;
            }
        }
    }

    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
