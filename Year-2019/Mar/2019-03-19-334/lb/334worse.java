class Solution {
//通过栈来保存前两位递增的情况，且实时变更前两位更小的最优的状态，当出现第三个更大的数时则满足要求。
    //其实没有必要使用栈，可以直接使用两个参数来记录最小的第一位和第二位数
    public boolean increasingTriplet(int[] nums) {
       int min = Integer.MAX_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int num : nums){
            if (num > min)
                return true;
            if (stack.size() == 0 || num > stack.peek())
                stack.push(num);
            else if (num < stack.peek()){
                while (stack.size() != 0 && num <= stack.peek()){
                    stack.pop();
                }
                stack.push(num);
            }
            if (stack.size() == 2 && num < min)
                min = num;
        }
        return false;
    }
}
