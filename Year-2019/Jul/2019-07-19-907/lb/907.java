/***
 * ░░░░░░░░░░░░░░░░░░░░░░░░▄░░
 * ░░░░░░░░░▐█░░░░░░░░░░░▄▀▒▌░
 * ░░░░░░░░▐▀▒█░░░░░░░░▄▀▒▒▒▐
 * ░░░░░░░▐▄▀▒▒▀▀▀▀▄▄▄▀▒▒▒▒▒▐
 * ░░░░░▄▄▀▒░▒▒▒▒▒▒▒▒▒█▒▒▄█▒▐
 * ░░░▄▀▒▒▒░░░▒▒▒░░░▒▒▒▀██▀▒▌
 * ░░▐▒▒▒▄▄▒▒▒▒░░░▒▒▒▒▒▒▒▀▄▒▒
 * ░░▌░░▌█▀▒▒▒▒▒▄▀█▄▒▒▒▒▒▒▒█▒▐
 * ░▐░░░▒▒▒▒▒▒▒▒▌██▀▒▒░░░▒▒▒▀▄
 * ░▌░▒▄██▄▒▒▒▒▒▒▒▒▒░░░░░░▒▒▒▒
 * ▀▒▀▐▄█▄█▌▄░▀▒▒░░░░░░░░░░▒▒▒
 * 单身狗就这样默默地看着你，一句话也不说。
 */

import java.util.Stack;

/**
 * @author ：lovelydragon
 * @date ：Created in 2019-09-09 18:43
 * @description：
 */
public class SumSubarrayMins {
    //子数组的最小值之和
    //单调递增栈 -- 连续子数组中的最小值
    //把位置为n做为最小值的数组的数量为(n-min+1)*(smaller-n+1)
    //最后最小的数组数量为(n)*(length-n+1)
    public int sumSubarrayMins(int[] A){
        long result = 0;
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> index = new Stack<>();
        for (int i = 0; i < A.length; i++){
            if (stack.isEmpty()){
                stack.push(A[i]);
                index.push(i);
            }else {
                if (A[i] > stack.peek()){
                    stack.push(A[i]);
                    index.push(i);
                }else {
                    while (!stack.isEmpty() && A[i]<=stack.peek()){
                        int num = stack.pop();
                        int n = index.pop();
                        //栈内的最后一个数
                        if (stack.isEmpty()){
                            result += num*((n+1)*(i-n));
                        }else {
                            result += num*((n-index.peek())*(i-n));
                        }
                    }
                    stack.push(A[i]);
                    index.push(i);
                }
            }
        }
        //解决stack中的数
        while (!stack.isEmpty()){
            int num = stack.pop();
            int n = index.pop();
            //栈内的最后一个数
            if (stack.isEmpty()){
                result += num*((n+1)*(A.length-n));
            }else {
                result += num*((n-index.peek())*(A.length-n));
            }
        }
        return (int)(result%((int)Math.pow(10,9)+7));
    }
    //分治求解
    //求数组的最小值+包含最小值的数组的数量为(left+1)*(right+1)
    //依旧timeOut
    //可以优化求min的复杂度为logn
    public int sumSubarrayMins_timeOut2(int[] A) {
        return (int)(getResult(A,0,A.length-1)%((int)(Math.pow(10,9)+7)));
    }
    private long getResult(int[] nums,int begin,int end){
        if (end < begin)
            return 0;
        if (end == begin)
            return nums[begin];
        long result = 0;
        //求最小值
        int min = Integer.MAX_VALUE;
        int index = begin;
        for (int i = begin; i <= end; i++) {
            if (min > nums[i]){
                min = nums[i];
                index = i;
            }
        }
        result = (index - begin + 1) * (end - index +1) * min;
        result += getResult(nums,begin,index-1);
        result += getResult(nums,index+1,end);
        return result;
    }
    //o(n2)
    public int sumSubarrayMins_timeOut(int[] A) {
        long result=0;
        //根据子集的最大长度的循环
        for (int i = 0; i < A.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < A.length; j++) {
                min = Math.min(min,A[j]);
                result+=min;
            }
        }
        return (int)(result%((int)Math.pow(10,9)+7));
    }
}
