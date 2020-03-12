/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
// 二叉树通用路径算法，不仅限于BST，36ms，83%
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        bool fp = false, fq = false;
        vector<TreeNode*> vp;
        vector<TreeNode*> vq;
        hlr(root, p, vp, fp);
        hlr(root, q, vq, fq);
        TreeNode* ret = nullptr;
        for (int i = 0; i < vp.size() && i < vq.size() && vp[i] == vq[i]; ++i) {
            ret = vp[i];
        }
        return ret;
    }
    
    void hlr(TreeNode* head, TreeNode* p, vector<TreeNode*>& vec, bool& flag) {
        if (!head) return;
        vec.push_back(head);
        if (head == p) { flag = true; return; }
        if (head->left && !flag) { hlr(head->left, p, vec, flag); if (!flag) vec.pop_back(); }
        if (head->right && !flag) { hlr(head->right, p, vec, flag); if (!flag) vec.pop_back(); }
    }
};