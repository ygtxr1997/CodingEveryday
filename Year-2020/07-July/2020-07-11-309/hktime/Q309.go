/*
* @Author: HK
* @Date:   2020-07-12 14:20:01
* @Last Modified by:   HK
* @Last Modified time: 2020-07-12 14:34:28
*/
// 接着动态规划
func maxProfit(prices []int) int {
    if len(prices) < 2{
        return 0
    }
    // 含有冷冻期的情况，需要在第i天买入时判断一下第i-1天有没有卖出，有的话不能买入
    dp := make([][]int, len(prices))
    for i := 0; i < len(prices); i++{
        dp[i] = make([]int, 2)
    }
    // dp[i][j] 表示第i天，状态为j时的收益
    // j = 1表示持有股票
    // 初始状态如下
    dp[0][0] = 0
    dp[0][1] = -prices[0]
    dp[1][0] = max(dp[0][0], dp[0][1] + prices[1])
    dp[1][1] = max(dp[0][1], dp[0][0] - prices[1])
    // 状态转移方程如下
    // 当前未持有，前一天也未持有，收益不变
    // dp[i][0] = dp[i-1][0]
    // 当前未持有，前一天持有，收益+prices[i]
    // dp[i][0] = dp[i-1][1] + prices[i]
    // 当前持有的情况也同理
    // dp[i][1] = dp[i-1][1]
    // 如果在第i天买入，需要第i-2天处于未持有的状态
    // dp[i][1] = dp[i-1][0] - prices[i]
    for i := 2; i < len(prices); i ++{
        dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
        dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])
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