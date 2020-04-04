// 以前做过的题，再复习一下
// 单调递减栈，当即将入栈元素大于栈顶时，入栈元素代表右边第一个比栈顶大的元素
// 并且栈顶的下一个元素是左边第一个比栈顶大的元素
class Solution {
public:
    int trap(vector<int>& height) {
        if (height.empty()) return 0;
        int n = height.size(), ans = 0;
        stack<int> st; // <index>
        for (int i = 0; i < n; ++i) {
            while (!st.empty() && height[st.top()] < height[i]) {
                int top = st.top();
                st.pop();
                if (st.empty()) break;
                int x = i - st.top() - 1;
                int y = min(height[i] - height[top], height[st.top()] - height[top]);
                ans += x * y;
            }
            st.push(i);
        }
        return ans;
    }
};