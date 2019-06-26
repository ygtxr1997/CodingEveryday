// 递归
// getTrees(begin, end)表示
// 生成从begin到end()的所有可能二叉搜索树vector

class Solution {
public:
	vector<TreeNode*> generateTrees(int n) {
		if (n == 0) return vector<TreeNode*> {};

		return getTrees(1, n);
	}

	vector<TreeNode*> getTrees(int begin, int end) {
		vector<TreeNode*> res;
		if (begin > end) {
			res.push_back(NULL);
			return res;
		}

		for (int i = begin; i <= end; i++) {
			vector<TreeNode*> leftTree = getTrees(begin, i - 1);
			vector<TreeNode*> rightTree = getTrees(i + 1, end);
			for (auto l : leftTree) {
				for (auto r : rightTree) {
					TreeNode* root = new TreeNode(i);
					root->left = l;
					root->right = r;
					res.push_back(root);
				}
			}
		}
		return res;
	}
};
