/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        
        int len = 0;
        ListNode fast = head;
        //事实上，在获取长度的时候，就可以把链表的首尾相接
        while(fast != null){
            fast = fast.next;
            len++;
        }
        
        k = k % len;
        if(k == 0)
            return head;
        
        fast = head;
        while (k-- > 0){
            fast = fast.next;
        }
        
        ListNode slow = head;
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
}