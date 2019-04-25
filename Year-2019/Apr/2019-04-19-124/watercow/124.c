// 用户ID为SEU.FidGet的解法
/**
        对于任意一个节点, 如果最大和路径包含该节点, 那么只可能是两种情况:
        1. 其左右子树中所构成的和路径值较大的那个加上该节点的值后向父节点回溯构成最大路径
        2. 左右子树都在最大路径中, 加上该节点的值构成了最终的最大路径
**/

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {

public:
    int maxPathSum(TreeNode* root) {
        getMax(root);
        return result;
    }

private:
    int result = INT_MIN;
    
    int getMax(TreeNode* r) {
        if(r == nullptr) return 0;
        int left = max(0, getMax(r->left)); // 如果子树路径和为负则应当置0表示最大路径不包含子树
        int right = max(0, getMax(r->right));
        result = max(result, r->val + left + right); // 判断在该节点包含左右子树的路径和是否大于当前最大路径和
        return max(left, right) + r->val;
    }
};
