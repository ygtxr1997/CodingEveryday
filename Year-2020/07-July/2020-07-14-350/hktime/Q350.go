/*
* @Author: HK
* @Date:   2020-07-13 22:28:48
* @Last Modified by:   HK
* @Last Modified time: 2020-07-13 22:30:05
*/
// 哈希表
func intersect(nums1 []int, nums2 []int) []int {
    if len(nums1) > len(nums2){
        return intersect(nums2, nums1)
    }
    map1 := make(map[int]int)
    var ret []int
    for _, num := range nums1{
        map1[num] ++
    }
    for _, num := range nums2{
        if map1[num] > 0{
            ret = append(ret, num)
            map1[num]--
        }
    }
    return ret
}
// 对于有序的，用两个指针从头遍历即可
func intersect(nums1 []int, nums2 []int) []int {
    sort.Ints(nums1)
    sort.Ints(nums2)
    l1, l2 := len(nums1), len(nums2)
    i, j := 0, 0
    ret := []int{}
    for i < l1 && j < l2{
        if nums1[i] < nums2[j]{
            i++
        }else if nums1[i] > nums2[j]{
            j++
        }else{
            ret = append(ret, nums1[i])
            i++
            j++
        }
    }
    return ret
}