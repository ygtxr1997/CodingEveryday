class Solution {
public:
    int longestSubstring(string s, int k) {
        if (k <= 1) return s.size();
        if (s.empty() || s.size() < k) return 0;

        // hashmap
        unordered_map<char, int> hash;
        for (char c: s) hash[c]++;

        // i来记录第一个不可能满足要求的索引位置
        int i = 0;
        while(i < s.size() && hash[s[i]] >= k) i++;
        if (i == s.size()) return s.size();

        // l表示从0-i位置的满足要求的最长子串长度
        int l = longestSubstring(s.substr(0,i), k);

        // 快速向右遍历过滤掉不可能满足要求的索引
        while(i < s.size() && hash[s[i]] < k) i++;
        
        // r找到i-end位置满足要求的最长子串长度
        int r = longestSubstring(s.substr(i), k);

        return max(l, r);
    }
};
