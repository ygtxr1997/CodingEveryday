/*
* @Author: HK
* @Date:   2020-07-12 10:41:28
* @Last Modified by:   HK
* @Last Modified time: 2020-07-12 15:11:58
*/
// 也是动态规划来做，原来的二维dp数组再加一维，记录买卖次数
func maxProfit(prices []int) int {
    n := len(prices)
    if n < 2{
        return 0
    }
    // 也是动态规划来做，原来的二维dp数组再加一维，记录买卖次数
    dp := make([][][]int, n)
    for i := 0; i < n; i++{
        dp[i] = make([][]int, 2)
        for j := 0; j < 2; j++{
            dp[i][j] = make([]int, 3)
        }
    }
    // dp[i][j][k] 表示第i天，状态为j时，进行了k笔交易的收益
    // j = 1表示持有股票，k在买入的时候更新
    // 初始状态如下
    dp[0][1][1] = -prices[0]
    dp[0][1][2] = -prices[0]
    // 状态转移方程如下
    // 判断状态转移时，要判断交易次数
    for i := 1; i < n; i ++{
        dp[i][0][1] = max(dp[i-1][0][1], dp[i-1][1][1] + prices[i])
        dp[i][1][1] = max(dp[i-1][1][1], dp[i-1][0][0] - prices[i])
        dp[i][0][2] = max(dp[i-1][0][2], dp[i-1][1][2] + prices[i])
        dp[i][1][2] = max(dp[i-1][1][2], dp[i-1][0][1] - prices[i])
    }
    return dp[n-1][0][2]
}
func max(a, b int)int{
    if a > b{
        return a
    }else{
        return b
    }
}