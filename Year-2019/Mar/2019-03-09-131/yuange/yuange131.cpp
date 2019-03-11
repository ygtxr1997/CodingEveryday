// 傻逼回溯法，如果是求个数，可以用dp
class Solution {
private:
    vector<vector<string>> vv; // 最终结果
    vector<string> v; // 临时结果
    
public:
    vector<vector<string>> partition(string s) {
        trace(s);
        return vv;
    }
    
    void trace(string s) {
        if (s.empty()) {
            vv.push_back(v);
            return;
        }
        for (int i = 1; i <= s.length(); ++i) {
            string son = s.substr(0, i);
            if (isPal(son)) {
                v.push_back(son);
                trace(s.substr(i));
                v.pop_back();
            }
        }
    }
    
    bool isPal(string& s) {
        int l = 0, r = s.size() - 1;
        while (l < r)
            if (s[l++] != s[r--]) return false;
        return true;
    }
};
