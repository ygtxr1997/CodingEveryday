// 最长公共子串，O(N^2)
// 288ms，14%
class Solution {
public:
    string longestPalindrome(string s) {
        string t(s);
        reverse(t.begin(), t.end());
        return lcm(t, s);
    }
    
    string lcm(string& s1, string& s2) {
        string ret;
        int m = 0;
        vector<vector<int>> dp(s1.size() + 1, vector<int>(s2.size() + 1));
        for (int i = 0; i < s1.size(); ++i) {
            for (int j = 0; j < s2.size(); ++j) {
                if (s1[i] == s2[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    // 这里要判断是否为回文串
                    if(dp[i + 1][j + 1] > m && s1[i] == s1[i - dp[i + 1][j + 1] + 1]) {
                        m = dp[i + 1][j + 1];
                        ret = s1.substr(i - m + 1, m);
                    }
                }
            }
        }
        return ret;
    }
};