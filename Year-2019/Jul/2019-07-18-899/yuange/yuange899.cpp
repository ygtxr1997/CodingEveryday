// 实际上是个数学问题，K=1时只能移动1个，K>=1时可以任意交换两个相邻字符的位置
// 4ms，81%
class Solution {
public:
    string orderlyQueue(string S, int K) {
        if (K == 1) {
            string res = S;
            for (int i = 0; i < S.size(); ++i) {
                string T = S.substr(i) + S.substr(0, i);
                if (T < res) res = T;
            }
            return res;
        } else {
            sort(S.begin(), S.end());
            return S;
        }
    }
};