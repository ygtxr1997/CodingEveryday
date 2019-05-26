class Solution {
    // //栈方法
    // public int trap(int[] height) {
    //     int outPut = 0;

    //     Stack<int[]> stack = new Stack<>();
    //     for(int pos = 0; pos < height.length; pos++){
    //         int h = height[pos];
    //         if(h == 0) continue;
    //         if(stack.isEmpty()){
    //             stack.push(new int[] {h, pos, 0});//h指高度，pos横坐标，0代表下一个较低高度的可能值
    //         }
    //         else {
    //             int pre = 0;
    //             while (!stack.isEmpty()&& h >= stack.peek()[0]){
    //                 int[] tmp = stack.pop();
    //                 outPut += (pos - tmp[1] - 1) * (tmp[0] - Math.max(pre, tmp[2]));
    //                 pre = tmp[0];
    //             }
    //             if(!stack.isEmpty()){
    //                 int[] tmp = stack.peek();
    //                 outPut += (pos - tmp[1] - 1) * (h - pre);
    //                 pre = tmp[0];
    //             }
    //             stack.push(new int[] {h, pos, 0});
    //         }
    //     }

    //     return outPut;
    // }

    //栈方法，删除无关代码
    public int trap(int[] height) {
        int outPut = 0;

        Stack<Integer> stack = new Stack<>();
        for(int pos = 0; pos < height.length; pos++){
            int h = height[pos];
            if(h == 0) continue;
            int pre = 0;
            while (!stack.isEmpty()&& h >= height[stack.peek()]){
                int tmp = stack.pop();
                outPut += (pos - tmp - 1) * (Math.min(h, height[tmp]) - pre);
                pre = height[tmp];
            }
            if(!stack.isEmpty()){
                int tmp = stack.peek();
                outPut += (pos - tmp - 1) * (Math.min(h, height[tmp]) - pre);
                pre = height[tmp];
            }
            stack.push(pos);
        }

        return outPut;
    }
}