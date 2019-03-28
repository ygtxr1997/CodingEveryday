class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums.length == 0) return nums;
        int max = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[max])
                max = i;
        }
        Stack<Integer> stack = new Stack();
        for(int i = max + 1; i < nums.length; i++){
            while(!stack.isEmpty()&& nums[stack.peek()] < nums[i]){
                nums[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
        for(int i = 0; i <= max; i++){
            while(!stack.isEmpty()&& nums[stack.peek()] < nums[i]){
                nums[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            nums[stack.pop()] = -1;
        }
        return nums;
    }
}