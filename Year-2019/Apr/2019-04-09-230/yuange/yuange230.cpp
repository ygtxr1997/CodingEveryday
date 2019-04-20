/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
// 中序遍历方法，二叉搜索树的左子树都比根小
class Solution {
public:
    int kthSmallest(TreeNode* root, int k) {
        int res = 0;
        search(root, k, res);
        return res;
    }
    
    void search(TreeNode* root, int& k, int& res) {
        if (!root || k < 0) return;
        search(root->left, k, res);
        if (0 == --k) {
            res = root->val;
            return;
        }
        search(root->right, k, res);
    }
};
