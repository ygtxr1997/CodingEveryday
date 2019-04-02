// 两个指针，一个指针走2，一个走1
// 看是否会重合

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
	bool hasCycle(ListNode *head) {
		ListNode * p1 = head;
		ListNode * p2 = head;

		while (p1 != NULL) {
			p1 = p1->next;
			if (p2->next != NULL) {
				p2 = p2->next;
			}
			if (p2->next != NULL) {
				p2 = p2->next;
			}
			else return false;
			if (p1 == p2) return true;
		}
		return false;
	}
};