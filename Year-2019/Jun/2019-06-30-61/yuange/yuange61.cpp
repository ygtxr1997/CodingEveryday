/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
// 8ms，93%
class Solution {
public:
    ListNode* rotateRight(ListNode* head, int k) {
        if (!head) return head;
        ListNode* p = head, *tail = nullptr;
        int num = 0;
        while (p) {
            if (!p->next) tail = p;
            p = p->next;
            num++;
        }
        k %= num;
        if (k == 0) return head;
        num -= k + 1;
        p = head;
        while (num) {
            p = p->next;
            num--;
        }
        ListNode* ret = p->next;
        p->next = nullptr;
        tail->next = head;
        return ret;
    }
};