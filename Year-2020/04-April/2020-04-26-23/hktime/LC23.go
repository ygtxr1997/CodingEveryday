/*
* @Author: HK
* @Date:   2020-07-02 22:07:02
* @Last Modified by:   HK
* @Last Modified time: 2020-07-02 23:08:24
*/
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
 // 两两合并
func mergeKLists(lists []*ListNode) *ListNode {
    if len(lists) == 0{
        return nil
    }
    if len(lists) == 1{
        return lists[0]
    }
    for len(lists) != 1{
        var tmp []*ListNode
        i := 0
        for ; i < len(lists)-1; i += 2{
            l1, l2 := lists[i], lists[i+1]
            node := mergeList(l1, l2)
            tmp = append(tmp, node)
        }
        if i + 1 == len(lists){
            tmp = append(tmp, lists[i])
        }
        lists = tmp
    }
    return lists[0]
}

func mergeList(l1, l2 *ListNode) *ListNode{
    if l1 == nil{
        return l2
    }
    if l2 == nil{
        return l1
    }
    dummy := &ListNode{Val:-1}
    p := dummy
    for l1 != nil && l2 != nil{
        if l1.Val < l2.Val{
            p.Next = l1
            l1 = l1.Next
        }else{
            p.Next = l2
            l2 = l2.Next
        }
        p = p.Next
    }
    if l1 != nil{
        p.Next = l1
    }else{
        p.Next = l2
    }
    return dummy.Next
}

// 最小堆
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
// go刷题也太麻烦了；)
type IntHeap []*ListNode
func (h IntHeap)Len()int{
    return len(h)
}
func (h IntHeap)Less(i, j int)bool{
    return h[i].Val < h[j].Val
}
func (h IntHeap)Swap(x, y int){
    h[x], h[y] = h[y], h[x]
}
func (h *IntHeap)Push(x interface{}){
    *h = append(*h, x.(*ListNode))
}
func (h *IntHeap)Pop()interface{}{
    length := len(*h)
    val := (*h)[length-1]
    *h = (*h)[:length-1]
    return val
}
func mergeKLists(lists []*ListNode) *ListNode {
    if lists == nil || len(lists) == 0{
        return nil
    }
    var h IntHeap // 最小堆
    heap.Init(&h)
    for _, list := range lists{
        if list != nil{
            heap.Push(&h, list)
        }
    }
    res := &ListNode{}
    tmp := res
    for h.Len() > 0{
        min := heap.Pop(&h).(*ListNode)
        tmp.Next = min
        tmp = tmp.Next
        if min.Next != nil{
            heap.Push(&h, min.Next)
        }
    }
    return res.Next
}