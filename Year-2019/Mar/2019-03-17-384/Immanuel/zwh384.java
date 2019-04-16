public class Solution {
    private int[] nums;
    private Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if(nums == null) return null;
        int[] a = nums.clone();
        // for(int j = 0; j < a.length; j++) {
        //     int i = random.nextInt(a.length);
        //     swap(a, i, j);
        // }
        
        //第j个数字有1/j的概率被留下，从而保证每个数字出现在每个位置的概率相同
        // for(int j = 1; j < a.length; j++) {
        //     int i = random.nextInt(j + 1);
        //     swap(a, i, j);
        // }
        //对于第i个元素，在洗牌后，其在n-1位置上的概率是1/n，其在第n-2位置上的概率为(n-1)/n * 1/(n-1)，
        //即第一次没有被选中到n-1位置上，第2次被选中了，到了n-2位置上，
        //相应的，第i个元素在n-j位置上的概率为(n-1)/n * (n-2)/(n-1) * ... * (n-j+1)/(n-j+2) * 1/(n-j+1)，为1/n 
        for(int j = a.length - 1; j >= 1; j--) {
            int i = random.nextInt(j + 1);
            swap(a, i, j);
        }
        
        
        return a;
    }
    
    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}