class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int diff = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            int j = i + 1, k = nums.length - 1;
            while (j < k){
                int tmp = nums[i] + nums[j] + nums[k];
                if(tmp == target)
                    return target;
                else if(tmp < target)
                    j++;
                else 
                    k--;
                if(Math.abs(tmp - target) < diff){
                    diff = Math.abs(tmp - target);
                    sum = tmp;
                }
            }
        }

        return sum;
    }
}