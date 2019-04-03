public class Solution {

    private ListNode reverseList(ListNode head) {
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


    public boolean isPalindrome(ListNode head) {
        if(head == null|| head.next == null)
            return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null&& fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null){
            slow = slow.next;
        }
        slow = reverseList(slow);
        while(slow != null){
            if(slow.val != head.val)
                return false;
            slow = slow.next;
            head = head.next;
        }

        return true;
    }
}