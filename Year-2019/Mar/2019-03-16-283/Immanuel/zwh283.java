class Solution {
    public void moveZeroes(int[] nums) {
        Queue<Integer> pos0 = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                pos0.offer(i);
            }
            else if(!pos0.isEmpty()){
                nums[pos0.poll()] = nums[i];
                nums[i] = 0;
                pos0.offer(i);
            }
        }
    }
}