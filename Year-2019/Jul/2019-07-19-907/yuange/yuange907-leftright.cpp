class Solution {
#define BASE 1000000007
public:
    int sumSubarrayMins(vector<int>& A) {
        vector<int> left(A.size(), 0);      // <index, count>
        vector<int> right(A.size(), 0);     // <index, count>
        vector<int> st;                     // <index>
        // left -> right
        for (int i = 0; i < A.size(); ++i) {
            if (st.empty()) { st.push_back(i); continue; }
            else if (A[i] < A[st.back()]) { 
                while (!st.empty() && A[i] < A[st.back()]) {
                    left[i] += left[st.back()] + 1;
                    st.pop_back();
                }
            }
            st.push_back(i);
        }
        // left <- right
        st.resize(0);
        for (int i = A.size() - 1; i >= 0; --i) {
            if (st.empty()) { st.push_back(i); continue; }
            else if (A[i] <= A[st.back()]) { 
                while (!st.empty() && A[i] <= A[st.back()]) {
                    right[i] += right[st.back()] + 1;
                    st.pop_back();
                }
            }
            st.push_back(i);
        }
        cout << endl;
        int ans = 0;
        for (int i = 0; i < A.size(); ++i) {
            ans = (ans + A[i] * ((left[i] + right[i] + 1) % BASE + (left[i] * right[i]) % BASE)) % BASE;
        }
        return ans;
    }
};