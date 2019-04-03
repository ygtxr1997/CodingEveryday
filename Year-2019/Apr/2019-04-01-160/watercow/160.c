struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
	ListNode * getIntersectionNode(ListNode *headA, ListNode *headB) {
		if (headA == NULL || headB == NULL) return NULL;

		// 首先让headB链表构成一个环
		ListNode * p0 = headB;
		while (p0->next != NULL) {
			p0 = p0->next;
		}
		p0->next = headB;


		// 剩下的工作就是找入口环的入口点
		ListNode * p1 = headA;
		ListNode * p2 = headA;
		while (p1 != NULL && p1->next != NULL) {
			p2 = p2->next;
			p1 = p1->next->next;
			if (p1 == p2) {
				p2 = headA;
				while (p2 != p1) {
					p2 = p2->next;
					p1 = p1->next;
				}
				p0->next = NULL;
				return p1;
			}
		}
		p0->next = NULL;
		return NULL;
	}
};