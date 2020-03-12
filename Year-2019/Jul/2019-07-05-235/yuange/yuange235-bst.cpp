/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
// 适用于bst的特殊方法，根据val的特性，28ms，99%
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        int L = p->val, R = q->val;
        TreeNode* node = root;
        while (node) {
            int val = node->val;
            if (val > L && val > R) node = node->left;
            else if (val < L && val < R) node = node->right;
            else return node;
        }
        return nullptr;
    }
};