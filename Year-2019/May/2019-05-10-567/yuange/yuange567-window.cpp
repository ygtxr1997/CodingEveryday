// 16ms, 47%
// 经分析发现，只需要滑动窗口从左到右一次遍历即可
class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        int n1 = s1.size();
        int n2 = s2.size();
        if (n1 > n2) return false;
        int dic1[26] = { 0 };
        int dic2[26] = { 0 };
        for (int i = 0; i < n1; ++i) {
            dic1[s1[i] - 'a']++;
            dic2[s2[i] - 'a']++;
        }
        for (int i = 0; i < n2 - n1; ++i) {
            if (judge(dic1, dic2)) return true;
            // 滑动窗口
            dic2[s2[i] - 'a']--;
            dic2[s2[n1 + i] - 'a']++;
        }
        return judge(dic1, dic2);   // 边界处理
    }
    
    bool judge(int dic1[], int dic2[]) {
        for (int i = 0; i < 26; ++i) 
            if (dic1[i] != dic2[i]) return false;
        return true;
    }
};