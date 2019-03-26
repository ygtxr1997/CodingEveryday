class Solution {
    private int[] sumTemp;
    private boolean canPart2(int[] nums, int pos, int part1, int part2){
        if(pos >= 0){
            if((part1 + sumTemp[pos] == part2)||(part2 + sumTemp[pos] == part1))
                return true;
            else{
                if(part1 + sumTemp[pos] > part2){
                    if(canPart2(nums, pos - 1, part1 + nums[pos], part2))
                        return true;
                }
                if(part2 + sumTemp[pos] > part1){
                    if(canPart2(nums, pos - 1, part1, part2 + nums[pos]))
                        return true;
                }
                return false;
            }
        }
        return false;
    }
    public boolean canPartition(int[] nums) {
        sumTemp = new int[nums.length];
        sumTemp[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            sumTemp[i] = sumTemp[i - 1] + nums[i];
        }
        if(sumTemp[nums.length - 1] % 2 != 0)
            return false;
        
        return canPart2(nums, nums.length - 1, 0, 0);
    }
}