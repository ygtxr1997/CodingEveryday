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
    // 判断两棵树是否相同
    bool isSame(TreeNode* a, TreeNode* b) {
        if (a == nullptr && b == nullptr) return true;
        return a && b && a->val == b->val && isSame(a->left, b->left) && isSame(a->right, b->right);
    }
    bool isSubtree(TreeNode* s, TreeNode* t) {
        if (s == nullptr && t == nullptr) return true;
        if (s == nullptr && t != nullptr) return false;
        // t要么和s相同, 要么和s的左子树相同, 要么和s的右子树相同
        return isSame(s, t) || isSubtree(s->left, t) || isSubtree(s->right, t);
    }
};