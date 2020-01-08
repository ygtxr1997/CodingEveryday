// 4ms, 36%
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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int>> res;
        if (!root) return res;
        queue<TreeNode*> qq; // 辅助队列
        TreeNode* node = root;
        qq.push(node);
        bool br = false; // 如果br为true，则出队列后还要翻转
        while (!qq.empty()) {
            vector<int> cur;
            queue<TreeNode*> old(qq);
            qq = queue<TreeNode*>();
            while (!old.empty()) {
                if (old.front()->left) qq.push(old.front()->left);
                if (old.front()->right) qq.push(old.front()->right);
                cur.push_back(old.front()->val);
                old.pop();
            }          
            if (br) reverse(cur.begin(), cur.end());
            br ^= 1;
            res.push_back(cur);
        }
        return res;
    }
};