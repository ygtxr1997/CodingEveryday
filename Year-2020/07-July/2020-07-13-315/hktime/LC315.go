/*
* @Author: HK
* @Date:   2020-07-11 23:52:54
* @Last Modified by:   HK
* @Last Modified time: 2020-07-11 23:53:32
*/
// 使用归并排序
type pair struct{
    val, idx int
}
func countSmaller(nums []int) []int {
    pairs := make([]pair, len(nums))
    for idx, val := range nums{
        pairs[idx] = pair{val, idx}
    }
    count := make([]int, len(nums))
    mergeSort(pairs,count, 0, len(nums)-1)
    return count
}
func merge(pairs []pair, count []int, left, mid, right int){
    temp := []pair{}
    i, j := left, mid+1
    for i <= mid && j <= right{
        if pairs[i].val <= pairs[j].val{
            count[pairs[i].idx] += (j-mid-1)
            temp = append(temp, pairs[i])
            i++
        }else{
            temp = append(temp, pairs[j])
            j++
        }
    }
    for i <= mid{
        temp = append(temp, pairs[i])
        count[pairs[i].idx] += (j-mid-1)
        i++
    }
    temp = append(temp, pairs[j:right+1]...)
    for idx, _ := range temp{
        pairs[left+idx] = temp[idx]
    }
    return
}

func mergeSort(pairs []pair, count []int, left, right int){
    if left < right{
        mid := left + (right - left) / 2
        mergeSort(pairs,count, left, mid)
        mergeSort(pairs,count, mid+1, right)
        merge(pairs,count, left, mid, right)
    }
}
// 使用二叉搜索树
type treeNode struct{
    Val int
    Count int // 多少个更小的节点
    Left *treeNode
    Right *treeNode
}

// 二叉搜索树怎么整
func bstInsert(node *treeNode, insertNode *treeNode, smallCount *int){
    // put in the left
    if insertNode.Val <= node.Val{
        node.Count++
        if node.Left != nil{
            bstInsert(node.Left, insertNode, smallCount)
        }else{
            node.Left = insertNode
        }
    }else{
        // put in the right
        // add the left tree node and node
        *smallCount = *smallCount + node.Count + 1
        if node.Right != nil{
            bstInsert(node.Right, insertNode, smallCount)
        }else{
            node.Right = insertNode
        }
    }
}

func countSmaller(nums []int) []int {
    n := len(nums)
    count := make([]int, n)
    if n < 2{
        return count
    }
    root := treeNode{Val: nums[n-1]}
    for i := n-2; i >= 0; i--{
        var data int
        bstInsert(&root, &treeNode{Val:nums[i]}, &data)
        count[i] = data
    }
    return count
}