public class Solution {
    private int val;

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0|| k == 0)
            return new int[0];

        int[] outPut = new int[nums.length - k + 1];
        int[] maxLeft = new int[nums.length];
        int[] maxRight = new int[nums.length];

        //通过maxLeft和maxRight两个数组，使得滑动窗口内最大值的求值，可以通过窗口内的“左半窗”与“右半窗”来解决
        maxLeft[0] = nums[0];
        maxRight[nums.length - 1] = nums[nums.length - 1];
        for(int i = 1; i < nums.length; i++){
            //并不一定要从nums的第一个元素开始进行划分，按照如0，1|2，3，4，5|6，7，8，9|10的方式进行划分也可以
            //但一定要保证，maxLeft与maxRight取值时，是按照同一划分方式进行计算的

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