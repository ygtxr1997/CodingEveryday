/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public ListNode mergeKLists(ListNode[] lists) {
        int count = lists.length;
        if(count < 1)
            return null;
        
        while(count != 1){
            int tmp = (count + 1) / 2;
            for(int i = 0; i + tmp < count; i++){
                lists[i] = mergeTwoLists(lists[i], lists[i + tmp]);
            }
            count = tmp;
        }
        
        return lists[0];
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode tmp = head;
        while(l1 != null&& l2 != null){
            if(l1.val < l2.val){
                tmp.next = l1;
                tmp = tmp.next;
                l1 = l1.next;
            }
            else{
                tmp.next = l2;
                tmp = tmp.next;
                l2 = l2.next;
            }
        }
        while(l1 != null){
            tmp.next = l1;
            tmp = tmp.next;
            l1 = l1.next;
        }
        while(l2 != null){
            tmp.next = l2;
            tmp = tmp.next;
            l2 = l2.next;
        }
        tmp.next = null;
        
        return head.next;
    }
}