/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
// 16ms，97%
// 每次递归结束都返回一棵树到ans中
// 把实现的细节都交给递归结构去做，思路太nb了
class Solution {
public:
    vector<TreeNode *> generateTrees(int n) {
        if (n) return generate(1, n);
        else return vector<TreeNode *>{};
    }
    
    // 生成以left~right形成的二叉搜索树
    vector<TreeNode *> generate(int left, int right) {
        vector<TreeNode *> ans;
        if (left > right) {
            ans.push_back(NULL);
            return ans;
        }
        for (int i = left; i <= right; i++) {
            vector<TreeNode *> left_nodes = generate(left, i - 1);
            vector<TreeNode *> right_nodes = generate(i + 1, right);
            for (TreeNode *left_node : left_nodes) {
                for (TreeNode *right_node : right_nodes) {
                    TreeNode *t = new TreeNode(i); // 复制生成新节点
                    t->left = left_node;
                    t->right = right_node;
                    ans.push_back(t);
                }
            }
        }
        return ans;
    }
};