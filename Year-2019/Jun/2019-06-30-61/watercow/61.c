class Solution {
public:
	ListNode * rotateRight(ListNode* head, int k) {
		if (head == nullptr) return nullptr;
		k = k % get_length(head);

		if (k == 0) return head;

		ListNode* h1 = head;
		ListNode* h2 = head;
		
		for (int i = 0; i < k; i++) {
			h2 = h2->next;
		}

		while (h2->next) {
			h2 = h2->next;
			h1 = h1->next;
		}
		h2->next = head;
		head = h1->next;
		h1->next = nullptr;
		return head;
	}

	int get_length(ListNode* head) {
		int len = 0;
		ListNode* node = head;
		while (node) {
			len++;
			node = node->next;
		}
		return len;
	}
};
