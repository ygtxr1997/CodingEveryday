class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int x[256];
        std::fill_n(x, 256, -1);
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.size(); i++){
            if (x[s[i]] != -1 && x[s[i]] >= start){
                max = (max > i - start  ) ? max : i - start;
                start = x[s[i]]+1;
            }
            x[s[i]] = i;
        }
        max = (max > s.size() - start  ) ? max : s.size() - start;
        return max;
    }
};