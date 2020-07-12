/*
* @Author: HK
* @Date:   2020-07-12 14:41:00
* @Last Modified by:   HK
* @Last Modified time: 2020-07-12 14:49:04
*/
// 动态规划
func maxProfit(prices []int, fee int) int {
    if len(prices) < 2{
        return 0
    }
    // 有手续费的情况下，在每次交易的时候加上手续费即可
    dp := make([][]int, len(prices))
    for i := 0; i < len(prices); i++{
        dp[i] = make([]int, 2)
    }
    // dp[i][j] 表示第i天，状态为j时的收益
    // j = 1表示持有股票，买入时还得算上手续费
    // 初始状态如下
    dp[0][0] = 0
    dp[0][1] = -prices[0]-fee
    // 状态转移方程如下
    // 当前未持有，前一天也未持有，收益不变
    // dp[i][0] = dp[i-1][0]
    // 当前未持有，前一天持有，收益+prices[i]
    // dp[i][0] = dp[i-1][1] + prices[i]
    // 当前持有的情况也同理
    // dp[i][1] = dp[i-1][1]
    // dp[i][1] = dp[i-1][0] - prices[i] -fee
    for i := 1; i < len(prices); i ++{
        dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
        dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i] -fee)
    }
    return dp[len(prices)-1][0]
}
func max(a, b int)int{
    if a > b{
        return a
    }else{
        return b
    }
}
// 优化一下空间
// 只要记录两个数即可
func maxProfit(prices []int, fee int) int {
    if len(prices) < 2{
        return 0
    }
    // 有手续费的情况下，在每次交易的时候加上手续费即可
    // dp表示收益
    // dp1表示持有股票，买入时还得算上手续费
    // 初始状态如下
    dp0 := 0
    dp1 := -prices[0] - fee
    // 状态转移方程如下
    // 当前未持有，前一天也未持有，收益不变
    // dp0 = dp0
    // 当前未持有，前一天持有，收益+prices[i]
    // dp0 = dp1 + prices[i]
    // 当前持有的情况也同理
    // dp1 = dp1
    // dp1 = dp0 - prices[i] -fee
    for i := 1; i < len(prices); i ++{
        temp := dp0
        dp0 = max(dp0, dp1 + prices[i])
        dp1 = max(dp1, temp - prices[i] - fee)
    }
    return dp0
}
func max(a, b int)int{
    if a > b{
        return a
    }else{
        return b
    }
}