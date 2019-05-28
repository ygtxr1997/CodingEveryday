/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // if(l1.next == null&& l1.val == 0)
        //     return l2;
        // if(l2.next == null&& l2.val == 0)
        //     return l1;
        
        ListNode head = new ListNode(-1);
        head.next = l1;
        ListNode pre = head;
        
        int carry = 0;
        while(l1 != null&& l2 != null){
            int sum = l1.val + l2.val + carry;
            l1.val = sum % 10;
            carry = sum / 10;
            pre = pre.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 == null&& l2 != null){
            pre.next = l2;
            l1 = pre.next;
        }
        
        while(l1 != null){
            int sum = l1.val + carry;
            l1.val = sum % 10;
            carry = sum / 10;
            pre = pre.next;
            l1 = l1.next;
        }
        if(carry != 0){
            pre.next = new ListNode(carry);
            pre.next.next = null;
        }
        
        return head.next;
    }
}