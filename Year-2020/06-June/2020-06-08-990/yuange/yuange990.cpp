// 先遍历相等的, 再遍历不等的
class Solution {
public:
    int UnionSet[1000]; // 并查集
    int find(int x) {
        if (x == UnionSet[x]) return x;
        return UnionSet[x] = find(UnionSet[x]);
    }
    bool equationsPossible(vector<string>& equations) {
        // init
        for (int i = 0; i < 1000; ++i) UnionSet[i] = i;
        for (string& str : equations) {
            int x = str[0], y = str[3];
            bool bEqual = (str[1] == '=');
            int r1 = find(x), r2 = find(y);
            if (bEqual) UnionSet[r1] = r2; // 加入并查集
        }
        for (string& str : equations) {
            int x = str[0], y = str[3];
            bool bEqual = (str[1] == '=');
            int r1 = find(x), r2 = find(y);
            if (!bEqual && r1 == r2) return false; 
        }
        return true;
    }
};