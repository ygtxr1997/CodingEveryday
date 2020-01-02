// 16ms，67%
// 最快最简洁的方法
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int x[256];
        std::fill_n(x, 256, -1);
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.size(); i++){
            // 仅当出现重复值并且该重复值不小于start的位置时，才更新start
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