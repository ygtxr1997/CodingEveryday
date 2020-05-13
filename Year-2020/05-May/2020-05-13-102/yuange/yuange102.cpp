/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> ret;
        if (!root) return ret;
        int level = 1;
        queue<TreeNode*> qu;
        qu.push(root);
        while (!qu.empty()) {
            vector<int> vec;
            int nxt_level = 0;
            for (int i = 0; i < level; ++i) {
                TreeNode* cur = qu.front();
                qu.pop();
                vec.push_back(cur->val);
                if (cur->left) {
                    qu.push(cur->left);
                    nxt_level++;
                }
                if (cur->right) {
                    qu.push(cur->right);
                    nxt_level++;
                }
            }
            level = nxt_level;
            ret.push_back(vec);
        }
        return ret;
    }
};