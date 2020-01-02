// 204ms,9%
// 直接用数组，时间复杂度O(n1*n2)
class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        int dic1[26] = { 0 };
        int n1 = s1.size();
        int n2 = s2.size();
        if (n1 > n2) return false;
        for (auto c : s1) dic1[c - 'a']++;
        for (int i = 0; i <= n2 - n1; ++i) {
            int dic2[26] = { 0 };
            for (int j = 0; j < n1; ++j)
                dic2[s2[i + j] - 'a']++;
            if(judge(dic1, dic2)) return true;
        }
        return false;
    }
    
    // 是否已包含全部字母
    bool judge(int dic1[], int dic2[]) {
        for (int i = 0; i < 26; ++i) {
            if (dic1[i] != dic2[i]) return false;
        }
        return true;
    } 
};