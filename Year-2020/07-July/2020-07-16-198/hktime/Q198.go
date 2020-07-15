/*
* @Author: HK
* @Date:   2020-07-15 22:51:58
* @Last Modified by:   HK
* @Last Modified time: 2020-07-15 22:52:34
*/
// 简单的动态规划
func rob(nums []int) int {
    n := len(nums)
    if n == 0{
        return 0
    }
    if n == 1{
        return nums[0]
    }
    dp := make([]int, n+1)
    dp[1] = nums[0]
    for i := 2; i < n+1; i ++{
        dp[i] = max(dp[i-1], dp[i-2]+nums[i-1])
    }
    return dp[n]
}
func max(a, b int)int{
    if a > b{
        return a
    }else{
        return b
    }
}

// 优化空间
func rob(nums []int) int {
    n := len(nums)
    if n == 0{
        return 0
    }
    if n == 1{
        return nums[0]
    }
    i1, i2 := 0, nums[0]
    for i := 2; i < n+1; i ++{
        i1, i2 = i2, max(i2, i1+nums[i-1])
    }
    return i2
}
func max(a, b int)int{
    if a > b{
        return a
    }else{
        return b
    }
}