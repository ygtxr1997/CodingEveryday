// 单调栈,4ms,96%
class Solution {
public:
    int trap(vector<int>& height) {
        if (height.empty()) return 0;
        int n = height.size();
        int res = 0;
        stack<int> st; // 存放索引
        st.push(0);
        for (int i = 1; i < n; ++i) {
            // 如果即将入栈的元素高度大于栈顶元素，
            // 此时栈顶元素下面的元素代表左边第一个比它高的，
            // 即将入栈的元素代表右边第一个比它高的
            while (!st.empty() && height[i] >= height[st.top()]) {
                int top = st.top();
                st.pop();
                if (st.empty()) break;
                int x = i - st.top() - 1;
                int y = min(height[st.top()], height[i]) - height[top];
                res += x * y;
            }
            st.push(i);
        }
        return res;
    }
};