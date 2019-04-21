/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
// 二叉树的序列化和反序列化，经典题目，44ms，84%
// 1.使用先序遍历序列化，就可以用队列辅助反序列化
// 2.stringstream 类型
// 3.因为 val 可能是负数，所以不要用'-'作为连接符
// 4.getline(isstream, string, char) 获得以 char 结尾的子串
class Codec {
public:
    
    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        string ret;
        encode(root, ret);
        return ret;
    }
    
    void encode(TreeNode* node, string& str) {
        if (!node) {
            str.append("*#");
            return;
        }
        // 先序遍历
        str.append(to_string(node->val) + "#");
        encode(node->left, str);
        encode(node->right, str);
    }
    
    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        stringstream is(data);
        queue<string> q; // 队列作为辅助
        string item;
        while (getline(is, item, '#'))
            q.push(item);
        return decode(q);
    }
    
    TreeNode* decode(queue<string>& q) {
        string s = q.front();
        q.pop();
        if (s == "*") return nullptr;
        TreeNode *node = new TreeNode(stoi(s));
        node->left = decode(q);
        node->right = decode(q);
        return node;
    }
};

// Your Codec object will be instantiated and called as such:
// Codec codec;
// codec.deserialize(codec.serialize(root));
