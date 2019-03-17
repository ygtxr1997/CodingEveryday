class Solution {

   int[] array;

    public Solution(int[] nums) {
        array = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return array;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] ret = Arrays.copyOf(array,array.length);
        int temp;
        //第n张牌与喜好的前n-1张牌随机替换--洗牌算法
        for (int i = 0;i<array.length;i++){
            int r = new Random().nextInt(i+1);//指定范围的随机数
            if (r!=i){
                temp = ret[r];
                ret[r] = ret[i];
                ret[i] = temp;
            }
        }
        return ret;
    }
}
