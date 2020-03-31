// 找出数量最多的任务
class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        int res = 0, most = 0;
        int dic[26] = { 0 };
        for (char task : tasks) dic[task - 'A']++;
        for (int i = 0; i < 26; ++i) most = max(most, dic[i]);
        for (int i = 0; i < 26; ++i) if (dic[i] == most) res++;
        return max(res + (most - 1) * (n + 1), (int)tasks.size());
    }
};