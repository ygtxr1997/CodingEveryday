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
    bool dfs(TreeNode* cur, TreeNode* target, vector<TreeNode*>& vec) {
        if (!cur) return 0;
        if (cur == target) {
            vec.push_back(target);
            return 1;
        }
        bool flag = 0;
        if (cur->left) {
            vec.push_back(cur);
            flag = dfs(cur->left, target, vec);
            if (!flag) vec.pop_back();
        }
        if (cur->right && !flag) {
            vec.push_back(cur);
            flag = dfs(cur->right, target, vec);
            if (!flag) vec.pop_back();
        }
        return flag;
    }
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        vector<TreeNode*> vecp;
        vector<TreeNode*> vecq;
        dfs(root, p, vecp);
        dfs(root, q, vecq);
        TreeNode* comFather = root;
        for (int i = 0; i < vecp.size() && i < vecq.size(); ++i) {
            if (vecp[i] == vecq[i]) comFather = vecp[i];
        }
        return comFather;
    }
};