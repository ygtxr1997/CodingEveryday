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
    void bfs(TreeNode* node, int deep, vector<int>& right) {
        if (!node) return;
        if (deep > right.size()) right.push_back(node->val);
        else right[deep - 1] = node->val;
        if (node->left) bfs(node->left, deep + 1, right);
        if (node->right) bfs(node->right, deep + 1, right);
    }
    
    vector<int> rightSideView(TreeNode* root) {
        vector<int> ret;
        bfs(root, 1, ret);
        return ret;
    }
};