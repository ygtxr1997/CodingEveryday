class Solution {
public:
    vector<int> maxDepthAfterSplit(string seq) {
        if (seq.empty()) return vector<int>();
        vector<int> ret(seq.size(), 0);
        int st = 0; // 栈的元素个数代表括号深度,或者直接用单个int表示栈的深度
        for (int i = 0; i < seq.size(); ++i) {
            if (st == 0 || seq[i] == '(') ret[i] = st++ % 2;
            else ret[i] = --st % 2;         
        }
        return ret;
    }
};