// 8ms，60%，bfs方法，不用unsigned long long的话会溢出，还是用dfs更好
class Solution {
private:
    typedef unsigned long long ull;
public:
    int widthOfBinaryTree(TreeNode* root) {
        if (!root) return 0;
        ull ans = 0, clevel = 0, left = 0;
        queue<pair<TreeNode*, pair<ull, ull>>> qu;  // <*node, <level, pos>>
        qu.push(make_pair(root, make_pair(0, 0)));
        while (!qu.empty()) {
            TreeNode* nd = qu.front().first;
            ull l = qu.front().second.first, p = qu.front().second.second;
            qu.pop();
            if (nd->left) qu.push(make_pair(nd->left, make_pair(l + 1, 2 * p)));
            if (nd->right) qu.push(make_pair(nd->right, make_pair(l + 1, 2 * p + 1)));
            if (l != clevel) { // 只需要在进入新一层的时候更新
                clevel = l;
                left = p;
            }
            ans = std::max(ans, p - left);
        }
        return ans + 1;
    }
};