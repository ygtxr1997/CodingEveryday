/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
// 24ms, 97%
// 深度优先搜索的思想
class Solution {
public:
    int maxPathSum(TreeNode* root) {
        dfs(root);
        return res;
    }
    
    int dfs(TreeNode* pNode) {
        if (!pNode) return -0x3f3f3f;
        int cur = pNode->val;
        if (!pNode->left && !pNode->right) {    // 节点为叶子
            res = cur > res ? cur : res;
            return cur;
        }
        int l = dfs(pNode->left);   // dfs(node)的含义是包含node节点的子树可延伸最大路径和,可能是负数
        int r = dfs(pNode->right);
        int big = l > r ? l : r;                 // 不包含根节点的最大路径和，只有左或者右
        int enable = cur > big + cur ? cur : big + cur;    // 包含根节点的可延伸最大路径和，左+中或者右加中
        int unable = cur > l + r + cur ? cur : l + r + cur; // 包含根节点的不可延伸最大路径和，左+中+右
        res = res > big ? res : big;
        res = res > enable ? res : enable;
        res = res > unable ? res : unable;
        return enable;
    }
private:
    int res = -0x3f3f3f;
};
