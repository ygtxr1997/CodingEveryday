public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null|| head.next == null)
            return head;
        ListNode pre = head;
        head = head.next;
        pre.next = null;
        ListNode tmp = head.next;
        while (tmp != null){
            head.next = pre;
            pre = head;
            head = tmp;
            tmp = head.next;
        }
        head.next = pre;
        return head;
    }
}