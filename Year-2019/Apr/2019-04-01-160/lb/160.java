/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int ALength = 0;
        int BLength = 0;
        int AStarte = 0;
        int BStarte = 0;
        ListNode node;
        node = headA;
        while (node != null){
            ALength ++;
            node = node.next;
        }
        node = headB;
        while (node != null){
            BLength++;
            node = node.next;
        }
        //使A和B链表统一长度，同一起跑点
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        if (ALength > BLength){
            AStarte = ALength - BLength +1;
            for (int i =1;i<AStarte;i++){
                nodeA = nodeA.next;
            }
        }
        else{
            BStarte  = BLength - ALength+1;
            for (int i =1 ;i<BStarte;i++){
                nodeB = nodeB.next;
            }
        }
        //找交点
        node = null;
        while (nodeA != null){
            if (nodeA == nodeB)
                return nodeA;
             nodeA = nodeA.next;
             nodeB = nodeB.next;
        }
        return null;
    }
}
