public class Solution {
    private int val;

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0|| k == 0)
            return new int[0];

        int[] outPut = new int[nums.length - k + 1];
        int[] maxLeft = new int[nums.length];
        int[] maxRight = new int[nums.length];

        maxLeft[0] = nums[0];
        maxRight[nums.length - 1] = nums[nums.length - 1];
        for(int i = 1; i < nums.length; i++){
            maxLeft[i] = (i % k == 0)? nums[i]: Math.max(maxLeft[i - 1], nums[i]);
            int tmp = nums.length - i - 1;
            maxRight[tmp] = ((i + 1) % k == 0)? nums[tmp]: Math.max(maxRight[tmp + 1], nums[tmp]);
        }

        for(int i = 0; i< outPut.length; i++){
            outPut[i] = Math.max(maxLeft[i + k - 1], maxRight[i]);

        }

        return outPut;
    }

}