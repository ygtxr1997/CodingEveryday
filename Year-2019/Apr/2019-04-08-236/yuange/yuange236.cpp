/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
// 两个节点的公共祖先，要么是root，要么在root的左子树中，要么在root的右子树中，24ms，95%
// 如果该树节点有父指针，就可以用求节点深度的方法
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (root == nullptr || root == p || root == q) return root;
        TreeNode *left = lowestCommonAncestor(root->left, p, q);
        TreeNode *right = lowestCommonAncestor(root->right, p, q);
        // 递归函数和return分开
        if (left != nullptr && right != nullptr) return root;
        else if (left != nullptr) return left;
        else if (right != nullptr) return right;
        return nullptr;
    }
};
