/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
// 难度应该算简单，想清楚就好，16ms，99%
class Solution {
public:
    ListNode* oddEvenList(ListNode* head) {
        if (!head || !head->next) return head;
        ListNode *c = head, *n = head->next, *mid = n;
        while (c->next && n->next) {
            c->next = n->next;
            c = c->next;
            n->next = c->next;
            n = n->next;
        }
        c->next = mid;
        return head;
    }
};
