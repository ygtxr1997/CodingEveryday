// dfs方法，不知道为啥就不溢出了，4ms，90%
class Solution {
private:
    unordered_map<int,unsigned> mp;
    unsigned maxwidth = 1;
public:
    void dfs(TreeNode* root, int level, unsigned pos)
    {
        if(root == nullptr) return;
        if(mp.find(level) == mp.end()) mp[level]=pos;
        else maxwidth = max(maxwidth, pos - mp[level] + 1);
        dfs(root->left, level + 1, 2 * pos);
        dfs(root->right, level + 1, 2 * pos + 1);
        return;
    }

    int widthOfBinaryTree(TreeNode* root) {
        if(root == nullptr) return 0;
        dfs(root, 0, 0);
        return maxwidth;
    }
};