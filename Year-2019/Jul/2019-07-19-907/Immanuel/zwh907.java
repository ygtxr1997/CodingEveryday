class Solution {
    //前后界数组法
    public int sumSubarrayMins(int[] A) {
        int MOD = 1_000_000_007;
        //计算前序数组
        Deque<Integer> stack = new LinkedList<>();
        int[] prev = new int[A.length];
        for(int i = 0; i < A.length; ++i){
            while (!stack.isEmpty() && A[i] <= A[stack.peekLast()]){
                stack.pollLast();
            }
            prev[i] = stack.isEmpty()? -1: stack.peekLast();
            stack.offerLast(i);
        }
        //计算后序数组
        stack.clear();
        int[] next = new int[A.length];
        for(int i = A.length - 1; i>= 0; --i){
            //当一个子数组有多个相同最小值时，采用最右，故应当是 A[i] < A[stack.peekLast()]
            //若采取最左，则应当是 A[i] <= A[stack.peekLast()]，相应地，计算前序数组的地方也要进行更改
            while (!stack.isEmpty() && A[i] < A[stack.peekLast()]){
                stack.pollLast();
            }
            next[i] = stack.isEmpty()? A.length: stack.peekLast();
            stack.offerLast(i);
        }
        //计算总值
        int sum = 0;
        for(int i = 0; i < A.length; i++){
            int tmp = (A[i] * (next[i] - i) * (i - prev[i])) % MOD;
            sum = (sum + tmp) % MOD;
        }

        return sum;
    }    
    
//     //最小值栈法，思想与O(N ^ 2)的暴力法接近
//     public int sumSubarrayMins(int[] A) {
//         int MOD = 1_000_000_007;

//         Stack<int[]> stack = new Stack();
//         int ans = 0, dot = 0;
//         for (int j = 0; j < A.length; ++j) {
//             // Add all answers for subarrays [i, j], i <= j
//             int count = 1;
//             while (!stack.isEmpty() && stack.peek()[0] >= A[j]) {
//                 int[] tmp = stack.pop();
//                 count += tmp[1];
//                 dot -= tmp[0] * tmp[1];
//             }
//             stack.push(new int[]{A[j], count});//val&count
//             dot += A[j] * count;
//             ans += dot;
//             ans %= MOD;
//         }

//         return ans;
//     }
    
    //时间复杂度O(N ^ 2)
    // public int sumSubarrayMins(int[] A) {
    //     int sum = 0;
    //     for(int i = 0; i < A.length; i++){
    //         int min = Integer.MAX_VALUE;
    //         for(int j = i; j < A.length; j++) {
    //             if (A[j] < min)
    //                 min = A[j];
    //             sum += min;
    //             sum %= (1000000007);
    //         }
    //     }
    //     return sum;
    // }
}