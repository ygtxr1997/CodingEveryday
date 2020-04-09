// 每次递归都可以选择加左括号或者右括号，但是括号的数量受总数n和匹配规则l>=r的限制
class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> ret;
        string str("");
        helper(n, 0, 0, str, ret);
        return ret;
    }

    void helper(int n, int l, int r, string& str, vector<string>& vec) {
        if (l > n || r > n || r > l) return;
        if (l == n && r == n) { vec.push_back(str); return; }
        // push
        str.push_back('(');
        helper(n, l + 1, r, str, vec);
        str.pop_back();
        // pop
        str.push_back(')');
        helper(n, l, r + 1, str, vec);
        str.pop_back();
    }
};