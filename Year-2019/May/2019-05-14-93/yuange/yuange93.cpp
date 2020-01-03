// 4ms,70%
// 回溯思路不难，但对0的处理要注意
class Solution {
private:
    int start[4] = {0, 1, 2, 3}; // 4节的起始位置
    vector<string> res; // 返回结果
    vector<string> tmp; // 4个数字
    string ms;
public:
    vector<string> restoreIpAddresses(string s) {
        if (s.size() > 12 || s.size() < 4) return res;
        ms = s;
        trace(0); // 从第0节开始
        return res;
    }
    
    // 回溯第k节
    void trace(int k) {
        // 终点
        if (k == 4) {
            string str;
            for (auto s : tmp) str += s + ".";
            str.pop_back();
            res.push_back(str);
            return;
        }
        // 剪枝
        if (start[k] >= ms.size()) return;
        // 主体, 为避免越界，分两种情况考虑
        string cur;
        if (k == 3) {
            cur = ms.substr(start[k]);
            if (judge(cur)) {
                tmp.push_back(cur);
                trace(k + 1);
                tmp.pop_back();
            }
        } else {
            for (start[k + 1] = start[k] + 1; start[k + 1] < ms.size(); start[k + 1]++) {
                cur = ms.substr(start[k], start[k + 1] - start[k]);
                if (judge(cur)) {
                    tmp.push_back(cur);
                    trace(k + 1);
                    tmp.pop_back();
                }
            }
        }
        
    }
    
    // 检验是否符合IP地址的一节
    bool judge(string& seg) {
        if (seg.empty()) return false;
        if (seg.size() > 1 && seg[0] == '0') return false;
        stringstream ss;
        int num;
        ss << seg;
        ss >> num;
        return (num >= 0 && num <= 255);
    }
};