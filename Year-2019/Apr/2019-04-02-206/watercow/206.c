class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        if (!head) return nullptr;

        ListNode * p1 = nullptr;
        ListNode * p2 = head;

        if (head->next == nullptr) return head;

        while (head->next) {
            p2 = head->next;
            head->next = p1;
            p1 = head;
            head = p2;
        } 
        head->next = p1;
        return head;
    }
};
