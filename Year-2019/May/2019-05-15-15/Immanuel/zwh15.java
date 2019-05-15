public class Solution{
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> outPut = new LinkedList<>();
        if(nums.length < 3)
            return outPut;
        
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0&& nums[i] == nums[i - 1])
                continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    List<Integer> tmp = new LinkedList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    outPut.add(tmp);
                    while (left < right&& nums[left] == nums[++left]);
                    while (left < right&& nums[right] == nums[--right]);
                }
                else if(sum < 0){
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return outPut;
    }
}