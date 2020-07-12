/*
* @Author: HK
* @Date:   2020-07-12 14:50:42
* @Last Modified by:   HK
* @Last Modified time: 2020-07-12 15:21:42
*/
func maxProfit(k int, prices []int) int {
    n := len(prices)
    if n < 2{
        return 0
    }
    // 需要考虑k贼大的情况，这时候退化成无限交易问题，Q122
    if k >= n / 2{
        return quickSolve(prices)
    }
    // 也是动态规划来做，原来的二维dp数组再加一维，记录买卖次数
    dp := make([][][]int, n)
    for i := 0; i < n; i++{
        dp[i] = make([][]int, 2)
        for j := 0; j < 2; j++{
            dp[i][j] = make([]int, k+1)
        }
    }
    // dp[i][j][k] 表示第i天，状态为j时，进行了k笔交易的收益
    // j = 1表示持有股票，k在买入的时候更新
    // 初始状态如下
    for z := 1; z <= k; z++{
        dp[0][1][z] = -prices[0]
    }
    // 状态转移方程如下
    // 判断状态转移时，要判断交易次数
    for i := 1; i < n; i ++{
        for z := 1; z <= k; z ++{
            dp[i][0][z] = max(dp[i-1][0][z], dp[i-1][1][z] + prices[i])
            dp[i][1][z] = max(dp[i-1][1][z], dp[i-1][0][z-1] - prices[i])
        }
    }
    return dp[n-1][0][k]
}
func max(a, b int)int{
    if a > b{
        return a
    }else{
        return b
    }
}
func quickSolve(prices []int)int{
    ret := 0
    for i := 1; i < len(prices); i++{
        if prices[i] > prices[i-1]{
            ret += (prices[i] - prices[i-1])
        }
    }
    return ret
}