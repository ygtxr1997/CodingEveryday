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
        stack<int> st1;
        stack<int> st2;
        ListNode* p = l1;
        while (p != nullptr) {
            st1.push(p->val);
            p = p->next;
        }
        p = l2;
        while (p != nullptr) {
            st2.push(p->val);
            p = p->next;
        }
        ListNode* ret = nullptr;
        int g = 0, c = 0;
        while (!st1.empty() && !st2.empty()) {
            c = (st1.top() + st2.top() + g) % 10;
            g = (st1.top() + st2.top() + g) / 10;
            ListNode* curp = new ListNode(c);
            curp->next = ret; // 头插
            ret = curp;
            st1.pop();
            st2.pop();
        }
        stack<int> &st = st1;
        if (st1.empty()) st = st2;
        while (!st.empty()) {
            c = (st.top() + g) % 10;
            g = (st.top() + g) / 10;
            ListNode* curp = new ListNode(c);
            curp->next = ret;
            ret = curp;
            st.pop();
        }
        if (g != 0) {
            ListNode* curp = new ListNode(g);
            curp->next = ret;
            ret = curp;
        }
        return ret;
    }
};