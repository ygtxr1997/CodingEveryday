// ans：数组A[]的连续子数组最小值之和,ans=dp[0]+dp[1]+...+dp[n-1]
// dp[i]：以A[i]结尾的子数组的最小值之和
// dp[i]=dp[i-1]+A[i]-(修正值offset)
// 修正值offset：新加入A[i]后，原来某些段的最小值变成了A[i]
// 对A[i]之前的每个段{offset+=(A[栈顶保存的下标]-A[i])*(栈顶保存的下标-栈顶第二个元素保存的下标)}
// 单调增栈st：从st[i-1]+1一直到st[i]代表一个段，且该段的最小值恰是A[st[i]]
class Solution {
public:
    int sumSubarrayMins(vector<int>& A) {
        int BASE = 1e9 + 7;
        stack<int> st;
        int ans = 0, sum = 0; // sum：以A[i]结尾的子数组的ans，相当于dp[i]
        for (int i = 0; i < A.size(); ++i) {
            while (!st.empty() && A[st.top()] >= A[i]) {
                int top = st.top(); st.pop();
                int new_top = st.empty() ? -1 : st.top();
                sum += ((A[i] - A[top]) % BASE * (top - new_top) % BASE);
            }
            sum = (sum + A[i]) % BASE;
            st.push(i);
            ans = (ans + sum) % BASE;
        }
        return ans % BASE;
    }
};