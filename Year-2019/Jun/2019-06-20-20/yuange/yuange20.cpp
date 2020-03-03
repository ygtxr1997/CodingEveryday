class Solution {
public:
    bool isValid(string s) {
        if (s.empty()) return true;
        stack<char> st;
        for (auto c : s) {
            if (!st.empty()) {
                char t = st.top();
                if ((t == '(' && c == ')')
                   || t == '[' && c == ']'
                   || t == '{' && c == '}') {
                    st.pop();
                    continue;
                }
            }
            st.push(c);
        }
        return st.empty();
    }
};