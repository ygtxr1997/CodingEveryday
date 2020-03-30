/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* left;
    Node* right;
    Node* next;

    Node() : val(0), left(NULL), right(NULL), next(NULL) {}

    Node(int _val) : val(_val), left(NULL), right(NULL), next(NULL) {}

    Node(int _val, Node* _left, Node* _right, Node* _next)
        : val(_val), left(_left), right(_right), next(_next) {}
};
*/
// 题目要求空间复杂度O(1)，所以不能用数组保存最左端节点
class Solution {
public:
    Node* connect(Node* root) {
        dfs(root);
        return root;
    }

    // 注意连接次序
    void dfs(Node* root) {
        if (!root || !root->left) return;
        root->left->next = root->right;
        if (root->next) root->right->next = root->next->left;
        connect(root->left);
        connect(root->right);
    }
};