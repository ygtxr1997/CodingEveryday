// 4ms，67%
class Solution {
public:
    int reverse(int x) {
        bool sign = x > 0 ? 1 : -1;
        stack<int> st;
        long base = 1, ret = 0;
        do {
            st.push(x % 10);
            x /= 10;
        } while (x);
        while (!st.empty() && st.top() == 0) {
            st.pop();
        }
        while (!st.empty()) {
            ret += st.top() * base;
            base *= 10;
            st.pop();
        }
        if (ret > INT_MAX || ret < INT_MIN) return 0;
        return sign ? ret : -ret;
    }
};