/*
* @Author: HK
* @Date:   2020-07-15 23:23:17
* @Last Modified by:   HK
* @Last Modified time: 2020-07-15 23:23:35
*/
// 做两次动态规划即可
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
    for i := 2; i < n; i ++{
        dp[i] = max(dp[i-1], dp[i-2]+nums[i-1])
    }
    tmp := dp[n-1]
    dp[1] = 0
    for i := 2; i < n+1; i ++{
        dp[i] = max(dp[i-1], dp[i-2]+nums[i-1])
    }
    return max(tmp, dp[n])
}
func max(a, b int)int{
    if a > b{
        return a
    }else{
        return b
    }
}