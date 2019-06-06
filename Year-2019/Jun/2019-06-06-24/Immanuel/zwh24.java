/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null|| head.next == null)
            return head;
        
        ListNode tmp = head.next;
        head.next = swapPairs(head.next.next);
        tmp.next = head;
        return tmp;
    }
        
//     public ListNode swapPairs(ListNode head) {
//         ListNode pre = new ListNode(-1);
//         pre.next = head;
//         head = pre;
//         ListNode tmp;
//         while (pre.next != null&& pre.next.next != null){
//             tmp = pre.next;
//             pre.next = tmp.next;
//             tmp.next = tmp.next.next;
//             pre.next.next = tmp;
//             pre = pre.next.next;
//         }

//         return head.next;
//     }
}