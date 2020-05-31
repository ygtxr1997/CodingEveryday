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
    bool isSym(TreeNode* n1, TreeNode* n2) {
        if (!n1 && !n2) return true;
        if ((!n1 && n2) || (n1 && !n2)) return false;
        if (!isSym(n1->left, n2->right)) return false;
        if (!isSym(n1->right, n2->left)) return false;
        if (n1->val != n2->val) return false;
        return true;
    }
    bool isSymmetric(TreeNode* root) {
        if (!root) return true;
        return isSym(root->left, root->right);
    }
};