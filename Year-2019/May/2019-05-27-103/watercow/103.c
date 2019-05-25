
// 两个stack 然后结合bfs层序遍历
class Solution {
public:
	vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
		vector<vector<int>> ret;

		if (root == nullptr) return ret;

		vector<int> tmp;
		stack<TreeNode*> st1, st2;
		TreeNode* curr = nullptr;
		st1.push(root);

		while (true) {
			while (!st1.empty())
			{
				curr = st1.top();
				st1.pop();
				tmp.push_back(curr->val);
				if(curr->left) st2.push(curr->left);
				if(curr->right) st2.push(curr->right);
			}

			if (!tmp.empty()) {
				ret.push_back(tmp);
				tmp.clear();
			}
			else break;

			while (!st2.empty()) {
				curr = st2.top();
				st2.pop();
				tmp.push_back(curr->val);
				if(curr->right) st1.push(curr->right);
				if(curr->left) st1.push(curr->left);
			}

			if (!tmp.empty()) {
				ret.push_back(tmp);
				tmp.clear();
			}
			else break;
		}

		return ret;
	}
};
