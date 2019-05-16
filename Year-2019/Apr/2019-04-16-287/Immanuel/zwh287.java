public class Solution{

    public int findDuplicate(int[] nums) {
        int slow = nums[0];
		int fast = nums[nums[0]];
		while (slow != fast)
		{
			slow = nums[slow];
			fast = nums[nums[fast]];
		}

		fast = 0;
		while (fast != slow)
		{
			fast = nums[fast];
			slow = nums[slow];
		}
		return slow;
    }

    // public int findDuplicate(int[] nums) {
    //     int k = nums.length;

    //     while (k > 0){
    //         int tmp = nums[0];
    //         if(tmp == nums[tmp]){
    //             return tmp;
    //         }
    //         else {
    //             nums[0] = nums[tmp];
    //             nums[tmp] = tmp;
    //         }
    //         k--;
    //     }

    //     return 0;
    // }
}