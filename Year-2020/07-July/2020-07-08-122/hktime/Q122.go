/*
* @Author: HK
* @Date:   2020-07-12 10:39:12
* @Last Modified by:   HK
* @Last Modified time: 2020-07-12 10:40:07
*/
// 遍历一遍，遇到比前一天大的就卖出，得到收益
func maxProfit(prices []int) int {
    profit := 0
    for i := 0 ; i < len(prices)-1; i++{
        if prices[i] < prices[i+1]{
            profit += (prices[i+1]-prices[i])
        }
    }
    return profit
}
// 动态规划法
func maxProfit(prices []int) int {
    dp := make([][]int, len(prices))
    for i := 0; i < len(prices); i++{
        dp[i] = make([]int, 2)
    }
    // dp[i][j] 表示第i天，状态为j时的收益
    // j = 1表示持有股票
    // 初始状态如下
    dp[0][0] = 0
    dp[0][1] = -prices[0]
    // 状态转移方程如下
    // 当前未持有，前一天也未持有，收益不变
    // dp[i][0] = dp[i-1][0]
    // 当前未持有，前一天持有，收益+prices[i]
    // dp[i][0] = dp[i-1][1] + prices[i]
    // 当前持有的情况也同理
    // dp[i][1] = dp[i-1][1]
    // dp[i][1] = dp[i-1][0] - prices[i]
    for i := 1; i < len(prices); i ++{
        dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
        dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
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