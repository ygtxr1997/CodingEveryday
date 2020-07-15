/*
* @Author: HK
* @Date:   2020-07-15 22:32:19
* @Last Modified by:   HK
* @Last Modified time: 2020-07-15 22:32:30
*/
// 动态规划
func numTrees(n int) int {
    dp := make([]int, n+1)
    dp[0] = 1
    dp[1] = 1
    for i := 2; i < n+1; i++{
        for j := 1; j <= i; j++{
            dp[i] += dp[j-1] * dp[i-j]
        }
    }
    return dp[n]
}