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
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        multimap<int, ListNode*> small; // 小根堆
        for (auto p : lists) {
            if (p) small.insert(make_pair(p->val, p));
        }
        ListNode* res = nullptr;
        ListNode* p = nullptr;
        while (!small.empty()) {
            ListNode* cur = small.begin()->second;
            int num = cur->val;
            if (!res) res = cur;
            if (p) p->next = cur;
            p = cur;
            small.erase(small.begin());
            if (!cur->next) continue;
            small.insert(make_pair(cur->next->val, cur->next));
        }
        return res;
    }
};