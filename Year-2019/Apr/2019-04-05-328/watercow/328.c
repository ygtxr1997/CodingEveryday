class Solution {
public:
	ListNode * oddEvenList(ListNode* head) {
		if (head == NULL || head->next == NULL) return head;
		ListNode * tmp_sigle = head;
		ListNode * double_head = head->next;
		ListNode * tmp_double = head->next;

		while (tmp_double != NULL && tmp_double->next != NULL) {
			tmp_sigle->next = tmp_sigle->next->next;
			tmp_double->next = tmp_double->next->next;
			tmp_sigle = tmp_sigle->next;
			tmp_double = tmp_double->next;
		}

		tmp_sigle->next = double_head;
		return head;
	}
};
