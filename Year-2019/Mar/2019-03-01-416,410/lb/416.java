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
/**
 * @author ：lovelydragon
 * @date ：Created in 2019-03-06 21:30
 * @description：把题目转换成用sum/2（前提sum为偶数）体积的背包去装体积和价值都是nums数组里面的物品的01背包问题
 */
public class CanPartition {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num: nums)
            sum += num;
        if (sum % 2 == 1)
            return false;
        sum /= 2;
        int length = nums.length;
        //在nums为体积和价值相同的物品，从中找出sum体积可以装下的最大价值的物品
        int[][] dp = new int[length][sum+1];
        for (int i=0;i<sum+1;i++)
            if (i>nums[0])
                dp[0][i] = nums[0];
            //转移方程
        for (int i=1;i<length;i++){
            for (int j=0;j<sum+1;j++){
                if (j<nums[i])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.max(dp[i-1][j],nums[i]+dp[i-1][j-nums[i]]);
            }
        }
        if (dp[nums.length-1][sum] == sum)
            return true;
        return false;
    }
}
