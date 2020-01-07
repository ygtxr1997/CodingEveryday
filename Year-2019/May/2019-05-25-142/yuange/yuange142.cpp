// 8ms, 97%
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
    ListNode *detectCycle(ListNode *head) {
        ListNode* l = head;
        ListNode* r = head;
        do {
            if (!l || !r) return nullptr;
            l = l->next;
            r = r->next;
            if (!r) return nullptr;
            r = r->next;
        } while (l != r);
        l = head;
        while (l != r) {
            l = l->next;
            r = r->next;
        }
        return l;
    }
};