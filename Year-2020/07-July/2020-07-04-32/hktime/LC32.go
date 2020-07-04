/*
* @Author: HK
* @Date:   2020-07-04 22:31:26
* @Last Modified by:   HK
* @Last Modified time: 2020-07-04 22:31:37
*/
func longestValidParentheses(s string) int {
    stack := []int{-1}
    ret := 0
    for i := 0; i < len(s); i++{
        if s[i] == '('{
            stack = append(stack, i)
        }else{
            stack = stack[:len(stack)-1]
            if len(stack) == 0{
                stack = append(stack, i)
            }else{
                ret = max(ret, i - stack[len(stack)-1])
            }
        }
    }
    return ret
}
func max(a,b int)int{
    if a > b{
        return a
    }else{
        return b
    }
}