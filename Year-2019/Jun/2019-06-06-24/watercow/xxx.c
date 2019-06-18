// 指针问题最好初始化一个p空节点在head节点前

class Solution {
public:
	ListNode * swapPairs(ListNode* head) {
		if (head == nullptr || head->next == nullptr) return head;

		ListNode* p = new ListNode(0);
		p->next = head;
		ListNode* tmp = p;
		while (tmp->next && tmp->next->next) {
			ListNode* start = tmp->next;
			ListNode* end = tmp->next->next;
			tmp->next = end;
			start->next = end->next;
			end->next = start;
			tmp = start;
		}
		return p->next;
	}
};
