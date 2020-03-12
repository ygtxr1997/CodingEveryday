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
    int maxDepth(TreeNode* root) {
        int res = 0;
        dfs(root, 0, res);
        return res;
    }
    
    void dfs(TreeNode* node, int k, int& m) {
        if (!node) {
            m = k > m ? k : m;
            return;
        }
        dfs(node->left, k + 1, m);
        dfs(node->right, k + 1, m);
    }
};