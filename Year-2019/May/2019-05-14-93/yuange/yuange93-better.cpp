// 更简洁的写法，根据4个path的长度从1~3来回溯
class Solution {
public:
    vector<string> restoreIpAddresses(string s) {
        if (s.size() > 12) return {};
        vector<string> res;
        trace(s, res, {}, 0);
        return res;
    }
    
    void trace(string& s, vector<string>& res, vector<string> path, int start) {
        // 终点
        if (start == s.size() && path.size() == 4) {
            res.push_back(path[0] + '.' + path[1] + '.' + path[2] + '.' + path[3]);
            return;
        }
        // 剪枝
        if (start > s.size() || path.size() > 4) return;
        // 主体, 每个path最长为3
        for (int i = 1; i < 4; ++i) {
            string sub = s.substr(start, i);
            if (sub.size() == 0 || (sub.size() > 1 && sub[0] == '0') || stoi(sub) > 255)
                continue;
            path.push_back(sub);
            trace(s, res, path, start + i);
            path.pop_back();
        }
    }
};