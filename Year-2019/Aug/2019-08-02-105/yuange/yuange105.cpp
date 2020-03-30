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
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        if (preorder.empty()) return nullptr;
        return helper(preorder, inorder, 0, preorder.size() - 1, 0, inorder.size() - 1, new TreeNode(preorder[0]));
    }
    
    TreeNode* helper(vector<int>& pre, vector<int>& in, int l1, int r1, int l2, int r2, TreeNode* me) {
        if (l1 > r1 || l2 > r2 || l1 < 0 || l2 < 0 || r1 >= pre.size() || r2 >= in.size()) return nullptr;
        if (!me) me = new TreeNode(pre[l1]);
        int root2 = -1; // inorder中根的位置
        for (int j = l2; j <= r2; ++j) {
            if (in[j] == pre[l1]) root2 = j;
        }
        me->left = helper(pre, in, l1 + 1, l1 + 1 + (root2 - 1 - l2), l2, root2 - 1, me->left);
        me->right = helper(pre, in, l1 + 1 + (root2 - l2), r1, root2 + 1, r2, me->right);
        return me;
    } 
};