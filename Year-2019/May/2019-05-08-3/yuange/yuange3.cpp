// 32ms，40%
// dp解法，关键是记录start的位置，由于遍历hash，时间较慢
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int ret = 0;
        vector<int> hash(256, -1);
        int n = s.size();
        if (n <= 1) return n;
        int cur = 1;
        int start = 0;
        hash[s[0]] = 0;
        for (int i = 1; i < n; ++i) {
            int c = s[i];
            if (hash[c] == -1) {                // 不重复
                cur++;
            } else {                            // 重复
                cur = cur - (hash[c] - start);
                start = hash[c] + 1;
                for (int j = 0; j < 256; j++)
                    if (hash[j] < start) hash[j] = -1;
            }
            hash[c] = i;
            ret = cur > ret ? cur : ret;                      
        }
        return ret;
    }
};