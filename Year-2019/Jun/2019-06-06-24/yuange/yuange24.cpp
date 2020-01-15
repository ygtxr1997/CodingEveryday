/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
// 0ms，100%
// pp->pn->qq
//  |   |
// tt  res
class Solution {
private:
    ListNode* pp;
    ListNode* qq;
    ListNode* res;
    ListNode* tt;
    ListNode* pn;
public:
    ListNode* swapPairs(ListNode* head) {
        pp = head;
        if (!pp) return nullptr;
        if (!pp->next) return pp;
        qq = head;
        while (pp) {
            if (tt) tt->next = pp;
            pn = pp->next;
            if (!pn) break;
            if (!res) res = pn;
            if (tt) tt->next = pn;
            tt = pp;
            qq = pn->next;
            pn->next = pp;
            pp->next = nullptr;
            pp = qq;
        }
        return res;
    }
};