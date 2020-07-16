/*
* @Author: HK
* @Date:   2020-07-17 00:07:52
* @Last Modified by:   HK
* @Last Modified time: 2020-07-17 00:09:03
*/
// 三次旋转
func rotate(nums []int, k int)  {
    n := len(nums)
    if n == 0 || k % n == 0 || n == 1{
        return
    }
    k %= n
    reverse(nums)
    reverse(nums[:k])
    reverse(nums[k:])
    
}
func reverse(nums []int){
    i, j := 0, len(nums)-1
    for i < j{
        nums[i], nums[j] = nums[j], nums[i]
        i++
        j--
    }
}
// 循环交换
// 特别注意n是k的倍数的情况
func rotate(nums []int, k int)  {
    n := len(nums)
    if n == 0 || k % n == 0 || n == 1{
        return
    }
    k %= len(nums)
    count := 0
    for start := 0; count < n; start++{
        for cur, tmp := start, nums[start]; count < n;{
            next := (cur + k) % n
            nextVal := nums[next]
            nums[next] = tmp
            cur = next
            tmp = nextVal
            count++
            if cur == start{
                break
            }
        }
    }
}