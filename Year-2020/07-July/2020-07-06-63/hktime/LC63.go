/*
* @Author: HK
* @Date:   2020-07-06 22:27:09
* @Last Modified by:   HK
* @Last Modified time: 2020-07-06 22:38:04
*/
func uniquePathsWithObstacles(obstacleGrid [][]int) int {
    m := len(obstacleGrid)
    if m == 0{
        return 0
    }
    n := len(obstacleGrid[0])
    // 二维dp
    dp := make([][]int, m)
    for i := 0; i < m; i++{
        dp[i] = make([]int, n)
    }
    // 初始化
    i := 0
    for i < m && obstacleGrid[i][0] == 0{
        dp[i][0] = 1
        i++
    }
    i = 0
    for i < n && obstacleGrid[0][i] == 0{
        dp[0][i] = 1
        i++
    } 
    for i = 1; i < m; i++{
        for j := 1; j < n; j++{
            if obstacleGrid[i][j] == 1{
                dp[i][j] = 0
            }else{
                dp[i][j] = dp[i][j-1] + dp[i-1][j]
            }
        }
    }
    return dp[m-1][n-1]
}

// 一维数组
func uniquePathsWithObstacles(obstacleGrid [][]int) int {
    m := len(obstacleGrid)
    if m == 0{
        return 0
    }
    n := len(obstacleGrid[0])
    // 一维dp
    dp := make([]int, n)
    // 初始化
    if obstacleGrid[0][0] == 0{
        dp[0] = 1
    }
    for i := 0; i < m; i++{
        for j := 0; j < n; j++{
            if obstacleGrid[i][j] == 1{
                dp[j] = 0
                continue
            }
            if j -1 >= 0{
                dp[j] += dp[j-1]
            }
        }
    }
    return dp[n-1]
}