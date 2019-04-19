/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null|| head.next == null)
            return head;
        
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        ListNode tmp = head.next.next;
        while (tmp != null&& tmp.next != null){
            odd.next = tmp;
            even.next = tmp.next;
            odd = odd.next;
            even = even.next;
            tmp = tmp.next.next;
        }
        if(tmp != null){
            odd.next = tmp;
            odd = odd.next;
        }
        
        odd.next = evenHead;
        even.next = null;


        return head;
    }

}