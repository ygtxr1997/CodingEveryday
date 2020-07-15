/*
* @Author: HK
* @Date:   2020-07-15 23:24:05
* @Last Modified by:   HK
* @Last Modified time: 2020-07-15 23:24:12
*/
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func rob(root *TreeNode) int {
    if root == nil{
        return 0
    }
    result := houseRob(root)
    return max(result[0], result[1])
}
func houseRob(root *TreeNode)[2]int{
    result := [2]int{0, 0}
    if root == nil{
        return result
    }
    left := houseRob(root.Left)
    right := houseRob(root.Right)
    result[0] = max(left[0], left[1]) + max(right[0], right[1])
    result[1] = root.Val + left[0] + right[0]
    return result
}
func max(a, b int)int{
    if a > b{
        return a
    }else{
        return b
    }
}