public class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < coins.length; j++){
                int pre = i - coins[j];
                if(pre < 0){
                    break;
                }
                else if(dp[pre] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[pre] + 1);
                }
            }
        }


        return dp[amount] == Integer.MAX_VALUE? -1: dp[amount];
    }
}