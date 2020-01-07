// 24ms, 66%
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* res = nullptr; // 结果头指针
        ListNode* p = nullptr; // 结果游标
        int c = 0, g = 0; // c本位,g进位
        while (l1 && l2) {
            int tmp = l1->val + l2->val + g;
            c = tmp % 10;
            g = tmp / 10;
            ListNode* node = new ListNode(c);
            if (!res) res = node;
            if (p) p->next = node;
            p = node;
            l1 = l1->next;
            l2 = l2->next;
        }
        ListNode* l = l1 ? l1 : l2;
        while (l) {
            int tmp = l->val + g;
            c = tmp % 10;
            g = tmp / 10;
            ListNode* node = new ListNode(c);
            p->next = node;
            p = node;
            l = l->next;
        }
        if (g) {
            ListNode* node = new ListNode(g);
            p->next = node;
        }
        return res;
    }
};