// 此题实际是递归问题, 递归解法，164ms，28%
class Solution {
public:
    int longestSubstring(string s, int k) {
        int n = s.size();
        return find(s, k, 0, n);
    }
    
    int find(string& s, int k, int l, int r) {
        int hash[26] = { 0 };
        for (int i = l; i < r; ++i) hash[s[i] - 'a']++;
        for (int i = l; i < r; ++i)
            if (hash[s[i] - 'a'] < k) return max(find(s, k, l, i), find(s, k, i + 1, r));
        return r - l;
    }
};
