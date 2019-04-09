// 搞了半天看懂题目，
// 输入的node就是指向要删除的节点的指针
// 所以没有head输入
// 直接在node上进行操作

class Solution {
public:
	void deleteNode(ListNode* node) {
		node->val = node->next->val;
		node->next = node->next->next;
	}
};
