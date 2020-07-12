/*
* @Author: HK
* @Date:   2020-07-12 10:37:29
* @Last Modified by:   HK
* @Last Modified time: 2020-07-12 10:38:12
*/
// 从左到右遍历一次
// 维护一个最小值，每次计算一下收益
func maxProfit(prices []int) int {
    if len(prices) == 0{
        return 0
    }
    now := prices[0]
    profit := 0
    for _, pri := range prices{
        if pri < now{
            now = pri
            continue
        }
        if pri - now > profit{
            profit = pri - now
        }
    }
    return profit
}