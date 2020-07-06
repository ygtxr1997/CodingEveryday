/*
* @Author: HK
* @Date:   2020-07-05 15:26:37
* @Last Modified by:   HK
* @Last Modified time: 2020-07-05 15:27:05
*/
// 动态规划
func isMatch(s string, p string) bool {
    // dp[i][j]表示s的前i个字符能否与p的前j个通配符相匹配
    dp := make([][]bool, len(s)+1)
    for i := 0; i < len(s)+1; i++{
        dp[i] = make([]bool, len(p)+1)
    }
    j := 1
    // 初始化
    dp[0][0] = true
    for j < len(p)+1 && p[j-1] == '*'{
        dp[0][j] = true
        j ++
    }
    // 转移方程
    for i := 1; i < len(s)+1; i++{
        for j := 1; j < len(p)+1; j++{
            if s[i-1]==p[j-1] || p[j-1] == '?'{
                dp[i][j] = dp[i-1][j-1]
            }else{
                if p[j-1] == '*'{
                    dp[i][j] = dp[i][j-1] || dp[i-1][j]
                }
            }
        }
    }
    return dp[len(s)][len(p)]

}