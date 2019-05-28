public class Solution{

//图的广度优先搜索算法
    // class Pair{
    //     int pos;
    //     int step;
    //     Pair(int x1, int x2){
    //         pos = x1;
    //         step = x2;
    //     }
    // }
    // public int numSquares(int n) {
    //     boolean[] isvisited = new boolean[n + 1];
    //     isvisited[n] = true;

    //     Queue<Pair> que = new LinkedList<>();
    //     que.offer(new Pair(n, 0));

    //     while (!que.isEmpty()){
    //         int pos = que.peek().pos;
    //         int step = que.poll().step;

    //         for(int i = 1; ; i++){
    //             int tmp = pos - i * i;
    //             if(tmp < 0)
    //                 break;
    //             else if(tmp == 0)
    //                 return step + 1;
    //             else if(!isvisited[tmp]) {
    //                 que.offer(new Pair(tmp, step + 1));
    //                 isvisited[tmp] = true;
    //             }
    //         }
    //     }
    //     return -1;
    // }


//动态规划的方法，思想如下
// dp[0] = 0 
// dp[1] = dp[0]+1 = 1
// dp[2] = dp[1]+1 = 2
// dp[3] = dp[2]+1 = 3
// dp[4] = Min{ dp[4-1*1]+1, dp[4-2*2]+1 } 
//       = Min{ dp[3]+1, dp[0]+1 } 
//       = 1				
// dp[5] = Min{ dp[5-1*1]+1, dp[5-2*2]+1 } 
//       = Min{ dp[4]+1, dp[1]+1 } 
//       = 2
// 						.
// 						.
// 						.
// dp[13] = Min{ dp[13-1*1]+1, dp[13-2*2]+1, dp[13-3*3]+1 } 
//        = Min{ dp[12]+1, dp[9]+1, dp[4]+1 } 
//        = 2
// 						.
// 						.
// 						.
// dp[n] = Min{ dp[n - i*i] + 1 },  n - i*i >=0 && i >= 1
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int limit = (int)Math.sqrt(n);
        for(int i = 1; i <= limit; i++){
            dp[i * i] = 1;
        }

        limit = 1;
        for(int i = 2; i <= n; i++){
            if(dp[i] == 1){
                limit = (int)Math.sqrt(i);
            }
            else {
                for(int j = 1; j <= limit; j++){
                    dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
                }
            }
        }
        
        return dp[n];
    }
//对于动态规划的方法，可以使用静态List避免冗余计算
    // static List<Integer> dp = new ArrayList<>();
    // static {
    //     dp.add(0);
    // }

    // public int numSquares(int n) {
    //     while (dp.size() <= n){
    //         int min = Integer.MAX_VALUE;
    //         int i = dp.size();
    //         int j = 1;
    //         while(i - j*j >= 0) {
    //             min = Math.min(min, dp.get(i - j*j) + 1);
    //             ++j;
    //         }
    //         dp.add(min);
    //     }
    //     return dp.get(n);
    // }

    
}