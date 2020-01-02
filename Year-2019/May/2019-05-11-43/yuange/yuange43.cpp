// 24ms, 19%
// 先实现加法，再利用竖式实现乘法
class Solution {
public:
    string multiply(string num1, string num2) {
        string res;
        int c = 0, g = 0;
        if (num1 == "0" || num2 == "0") return "0";
        for (int i = num2.size() - 1; i >= 0 ; --i) {
            int n2 = num2[i] - '0';
            string tmp(num2.size() - 1 - i, '0'); // 塞0
            int c = 0, g = 0;
            for (int j = num1.size() - 1; j >= 0; --j) {
                int cur = (num1[j] - '0') * n2 + g;
                c = cur % 10; // 本位
                g = cur / 10; // 进位
                tmp.push_back('0' + c);
            }
            if (g) tmp.push_back('0' + g);
            res = add(res, tmp);
        }
        reverse(res.begin(), res.end());
        return res;
    }
    
    // 字符串加法
    string add(string& num1, string& num2) {
        if (num1.empty()) return num2;
        string l = num1.size() > num2.size() ? num1 : num2;
        string s = num1.size() > num2.size() ? num2 : num1;
        int len = s.size();
        string res;
        int c = 0, g = 0;
        for (int i = 0; i < l.size(); ++i) {
            int cur = i < len ? (l[i] - '0') + (s[i] - '0') + g : (l[i] - '0') + g;
            c = cur % 10; // 本位
            g = cur / 10; // 进位
            res.push_back('0' + c);
        }
        if (g) res.push_back('0' + g);
        return res;
    }
};