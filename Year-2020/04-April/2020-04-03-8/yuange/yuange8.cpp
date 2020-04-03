class Solution {
public:
    int myAtoi(string str) {
        if (str.empty()) return 0;
        string num; // 有效数字部分
        int n = str.size(), i = 0, sign = 1;
        while (i < n && str[i] == ' ') i++;
        if (i >= n) return 0; // 全空
        if (str[i] == '+' || str[i] == '-') { sign = str[i++] == '+' ? 1 : -1; } // 正负
        if (i >= n || str[i] < '0' || str[i] > '9') return 0; // 字符非数字
        while (i < n && str[i] == '0') i++; // 前导0
        while (i < n && str[i] >= '0' && str[i] <= '9') num.push_back(str[i++]);
        long lnum = 0, base = 1;
        for (int k = num.size() - 1; k >= 0; --k) {
            lnum += ((num[k] - '0') * base);
            if (base > INT_MAX) return sign == 1 ? INT_MAX : INT_MIN; // 超出最大表示范围
            base *= 10;
        }
        lnum *= sign;
        if (lnum > INT_MAX) return INT_MAX;
        if (lnum < INT_MIN) return INT_MIN;
        return lnum;
    }
};