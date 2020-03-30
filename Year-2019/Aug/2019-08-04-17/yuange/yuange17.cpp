// 简单的回溯
class Solution {
private:
    vector<string> dic = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
public:
    vector<string> letterCombinations(string digits) {
        vector<string> ret;
        if (digits.empty()) return ret;
        string cur;
        dfs(ret, digits, cur, 0);
        return ret;
    }
    
    void dfs(vector<string>& vec, string& digits, string& cur, int pos) {
        if (pos >= digits.size() || cur.size() == digits.size()) {
            vec.push_back(cur);
            return;
        }
        for (auto c : dic[digits[pos] - '2']) {
            cur.push_back(c);
            dfs(vec, digits, cur, pos + 1);
            cur.pop_back();
        }
    }
};