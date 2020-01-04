// 300ms
// 比较慢的常规枚举字典序解法
class Solution {
public:
    string getPermutation(int n, int k) {
        vector<int> vec;
        for (int i = 1; i <= n; ++i) vec.push_back(i);
        do {
            //print(vec);
        } while (--k && next_permutation(vec.begin(), vec.end()));
        string res;
        for (auto v : vec) res.push_back('0' + v);
        return res;
    }
    
    void print(vector<int>& vec) {
        for (auto v : vec) cout << v << ' ';
        cout << endl;
    }
};