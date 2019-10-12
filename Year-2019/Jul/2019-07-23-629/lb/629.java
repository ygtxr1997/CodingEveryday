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

import java.util.Map;

/**
 * @author ：lovelydragon
 * @date ：Created in 2019-10-11 14:15
 * @description：
 */
public class KInversePairs {
    //K个逆序对数组
    //动态规划
    //递归公式：f(n,k) = f(n-1,k) + f(n-1,k-1) + ... + f(n-1,k-n+1)
    //f(n,k) = f(n-1,k) + f(n,k-1) - f(n-1,k-n)
    //当k=0时f为1，当n=1且k!=0时f为0
    //当k<n时f的值为0
    public int kInversePairs(int n, int k) {
        //多次调用pow运算也会占用很长的时间
        int MOD = (int)Math.pow(10,9)+7;
        int[][] dp = new int[n+1][k+1];
        for (int i = 0; i <  n+1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < k+1; j++) {
                if (j>=i){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-i];
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
                if (dp[i][j] < 0)
                    dp[i][j] += MOD;
                else {
                    dp[i][j] %= MOD;
                }
            }
        }
        return dp[n][k];
    }
}
