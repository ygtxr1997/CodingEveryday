//令我恶心，用个max加速一下算了，口区
public class Solution{
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> outPut = new LinkedList<>();

        int max = Integer.MIN_VALUE;
        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] > max){
                outPut.add(0, outPut.size());
                max = nums[i];
            }
            else {
                int count = 0;
                for(int j = i + 1; j < nums.length; j++){
                    if(nums[j] < nums[i])
                        count++;
                }
                outPut.add(0, count);
            }
        }

        return outPut;
    }
}