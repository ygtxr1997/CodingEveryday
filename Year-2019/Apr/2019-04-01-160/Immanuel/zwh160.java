public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null|| headB == null)
            return null;
        ListNode tmp = headA;
        while(tmp.next != null){
            tmp = tmp.next;
        }
        tmp.next = headB;
        ListNode tmp_s = headA;
        ListNode tmp_f = headA;
        while(tmp_f != null&& tmp_f.next != null){
            tmp_s = tmp_s.next;
            tmp_f = tmp_f.next.next;
            if(tmp_s == tmp_f){
                break;
            }
        }
        if(tmp_f == null|| tmp_f.next == null){
            tmp.next = null;
            return null;
        }
        tmp_s = headA;
        while(tmp_s != tmp_f){
            tmp_s = tmp_s.next;
            tmp_f = tmp_f.next;
        }
        tmp.next = null;
        return tmp_s;
    }
}