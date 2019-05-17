public class Solution{
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int middle = (left + right) / 2;
            if(target == nums[middle]){
                return middle;
            }
            else if(nums[left] <= nums[middle]){//按左右侧是否有序来进行分治
                if(target < nums[middle]&& target >= nums[left])
                    right = middle - 1;
                else
                    left = middle + 1;
            }
            else {
                if(target > nums[middle]&& target <= nums[right])
                    left = middle + 1;
                else
                    right = middle - 1;
            }
        }

        return -1;
    }
}