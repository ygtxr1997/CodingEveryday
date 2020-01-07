// 8ms, 78%
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
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        if (!l1 && !l2) return nullptr;
        else if (!l1 || !l2) return l1 ? l1 : l2;
        ListNode* res = nullptr;
        ListNode* p = nullptr;
        while (l1 && l2) {
            int cur = 0;
            if (l1->val < l2->val) {
                cur = l1->val;
                l1 = l1->next;
            } else {
                cur = l2->val;
                l2 = l2->next;
            }
            ListNode* node = new ListNode(cur);
            if (!res) res = node;
            if (p) p->next = node;
            p = node;
        }
        p->next = l1 ? l1 : l2;
        return res;
    }
};