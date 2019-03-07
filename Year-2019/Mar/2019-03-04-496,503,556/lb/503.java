class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack =  new Stack<>();
        int[] ret = new int[nums.length];
        for (int i=0;i<nums.length;i++){
            if (stack.size()==0 || nums[stack.peek()]>= nums[i]){
                stack.push(i);
            }else {
                while(stack.size()>0 && nums[stack.peek()] < nums[i]){
                    ret[stack.pop()] = nums[i];
                }
                stack.push(i);
            }
        }
        int i =0;
        while(i<nums.length){
            if (stack.size()==0)
                break;
            if (nums[i]>nums[stack.peek()])
                ret[stack.pop()] = nums[i];
            else
                i++;
        }
        while (stack.size() > 0)
            ret[stack.pop()] = -1;
        return ret;
    }
}
