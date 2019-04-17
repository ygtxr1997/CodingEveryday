struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 };
 
class Codec {
public:

    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        if(root == nullptr) return "*_";
        string res = to_string(root->val) + "_";
        res += serialize(root->left);
        res += serialize(root->right);
        return res;
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        stringstream ss(data);
        string item;
        queue<string> q;
        while(getline(ss, item, '_'))
            q.push(item);
        return get_head(q);
    }

    TreeNode * get_head(queue<string>& q) {
        string val = q.front();
        q.pop();
        if (val == "*") return nullptr;
        TreeNode * head = new TreeNode(stoi(val));
        head->left = get_head(q);
        head->right = get_head(q);
        return head;
    }
};

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet* obj = new RandomizedSet();
 * bool param_1 = obj->insert(val);
 * bool param_2 = obj->remove(val);
 * int param_3 = obj->getRandom();
 */
