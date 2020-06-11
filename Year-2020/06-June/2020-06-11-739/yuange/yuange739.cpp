// 单调栈
class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& T) {
        vector<int> ret(T.size(), 0);
        stack<int> st;
        for (int i = 0; i < T.size(); ++i) {
            while (!st.empty() && T[st.top()] < T[i]) {
                ret[st.top()] = i - st.top();
                st.pop();
            }
            st.push(i);
        }
        return ret;
    }
};