// 根右左遍历，用visited数组辅助，最后翻转遍历结果
// 0ms，100%
class Solution {
public:
    vector<int> postorderTraversal(TreeNode* root) {
        if (!root) return vector<int>();
        vector<int> ret;
        stack<TreeNode*> st;
        map<TreeNode*, bool> visited;
        TreeNode* nd = root;
        st.push(nd);
        ret.push_back(nd->val);
        visited[nd] = true;
        while (!st.empty()) {
            nd = st.top();
            if (nd->right && visited[nd->right] == false) { nd = nd->right; visited[nd] = true; }
            else if (nd->left && visited[nd->left] == false) { nd = nd->left; visited[nd] = true; }
            else { st.pop(); continue; }
            ret.push_back(nd->val);
            st.push(nd);
        }
        reverse(ret.begin(), ret.end());
        return ret;
    }
};