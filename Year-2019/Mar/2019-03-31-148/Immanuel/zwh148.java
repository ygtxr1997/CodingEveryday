class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null|| head.next == null)
            return head;

        ListNode tail = head;
        int length = 0;
        while(tail != null){
            length++;
            tail = tail.next;
        }

        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode left, right;
        for(int step = 1; step < length; step <<= 1){
            tail = pre;
            left = tail.next;
            right = left;
            for(int i = 0; i < step&& right != null; i++){
                right = right.next;
            }
            while(right != null){
                tail = merge(tail, left, right, step);
                left = tail.next;
                right = left;
                for(int i = 0; i < step&& right != null; i++){
                    right = right.next;
                }
            }
        }

        return pre.next;
    }
    private ListNode merge(ListNode tail, ListNode l1, ListNode l2, int step){
        int count1 = 0, count2 = 0;
        while (count1 < step&& count2 < step&& l1 != null&& l2 != null){
            if(l1.val <= l2.val){
                tail.next = l1;
                count1++;
                l1 = l1.next;
            }
            else{
                tail.next = l2;
                count2++;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        while (count1 < step&& l1 != null){
            tail.next = l1;
            count1++;
            l1 = l1.next;
            tail = tail.next;
        }
        while (count2 < step&& l2 != null){
            tail.next = l2;
            count2++;
            l2 = l2.next;
            tail = tail.next;
        }
        tail.next = l2;
        return tail;
    }
}