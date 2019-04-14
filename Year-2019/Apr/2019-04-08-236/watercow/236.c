class Solution {
public:
	TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
		if (root == nullptr) return root;
		if (root == p) return p;
		if (root == q) return q;

		TreeNode* leftNode = lowestCommonAncestor(root->left, p, q);
		TreeNode* rightNode = lowestCommonAncestor(root->right, p, q);

		if (leftNode != nullptr && rightNode != nullptr) return root;
		else if (leftNode != nullptr) return leftNode;
		else if (rightNode != nullptr) return rightNode;
		return nullptr;
	}
};
