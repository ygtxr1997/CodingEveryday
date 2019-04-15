 // 中序遍历，判断当前root是否为第K个
 class Solution {
 public:
	 int kthSmallest(TreeNode* root, int k) {
		 stack<TreeNode*> path;
		 if (!root) return -1;

		 while (root) {
			 path.push(root);
			 root = root->left;
		 }

		 while (!path.empty()) {
			 auto node = path.top();
			 path.pop();
			 if (!--k) return node->val;
			 node = node->right;

			 while (node) {
				 path.push(node);
				 node = node->left;
			 }
		 }

		 return -1;
	 }
 };
