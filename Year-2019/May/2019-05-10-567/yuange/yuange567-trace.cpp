// 回溯法,用回溯法，由于函数调用层次和分支过多，会比数组法更慢
class Solution {
private:
    string m_s2;
    int dic[26] = { 0 };
public:
    bool checkInclusion(string s1, string s2) {
        int n = s2.size();
        m_s2 = s2;
        for (auto c : s1) dic[c - 'a']++;
        for (int i = 0; i < n; ++i)
            if (trace(i)) return true;
        return false;
    }
    
    // 回溯主体
    bool trace(int i) {
        // 回溯终点
        if (judge(dic)) return true;
        // 剪枝
        if (i >= m_s2.size()) return false;
        int c = m_s2[i] - 'a';
        if (dic[c] < 0) return false;
        // 记录
        dic[c]--;
        int ret = trace(i + 1);
        dic[c]++;
        return ret;
    }
    
    // 是否已包含全部字母
    bool judge(int dic[]) {
        for (int i = 0; i < 26; ++i)
            if (dic[i] != 0) return false;
        return true;
    } 
};