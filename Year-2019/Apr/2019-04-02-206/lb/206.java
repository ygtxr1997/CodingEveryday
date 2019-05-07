/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
//使用迭代的方法：记录前一个节点（初始为null），当前节点和中间节点（中间记录下一个节点）。
//循环的跳出条件是当前节点不为空
/**
while (cur != null){
    temp = cur.next;
    cur.next = pre;
    pre = cur;
    cur = temp;
}
*/
     //使用递归的方法
    public ListNode reverseList(ListNode head){
        if (head == null)
            return head;
        ListNode listHead = head;
        //找到最后一个节点作为头指针返回
        while (listHead.next != null)
            listHead = listHead.next;
        recusion(head);
        return listHead;
    }

//在递归的过程，存储当前节点，递归获得下一个节点
    public ListNode recusion(ListNode listNode){
        if (listNode.next == null)
            return listNode;
        ListNode cur = listNode;
        ListNode next = recusion(listNode.next);
        next.next = cur;
        cur.next = null;
        return cur;
    }
}
