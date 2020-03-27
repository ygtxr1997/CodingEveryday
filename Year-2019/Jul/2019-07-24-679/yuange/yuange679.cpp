class Solution {
private:
    typedef pair<int, int> NUM;
public:
    bool judgePoint24(vector<int>& nums) {
        vector<NUM> vec;
        for (int n : nums) vec.push_back(NUM(n, 1));
        return can24(vec, 0, vec.size() - 1);
    }
    
    bool can24(vector<NUM>& vec, int l, int r) {
        if (l == r) {
            int x = vec[l].first, y = vec[l].second;
            return (y != 0) && (x % y == 0) && (x / y == 24);
        }
        bool flag = false;
        for (int i = l; i < r; ++i) {
            for (int j = i + 1; j <= r; ++j) {
                NUM N0 = vec[i], N1 = vec[j], L0 = vec[l], L1 = vec[l + 1];
                if (i == l + 1) {vec[l] = N1, vec[j] = L0;}
                else {vec[l] = N0, vec[l + 1] = N1, vec[i] = L0, vec[j] = L1;}
                for (int op = 0; op < 6; ++op) {
                    if (op == 0) vec.push_back(NUM(N0.first * N1.second + N0.second * N1.first, N0.second * N1.second));
                    else if (op == 1) vec.push_back(NUM(N0.first * N1.second - N0.second * N1.first, N0.second * N1.second));
                    else if (op == 2) vec.push_back(NUM(N0.second * N1.first - N0.first * N1.second, N0.second * N1.second));
                    else if (op == 3) vec.push_back(NUM(N0.first * N1.first, N0.second * N1.second));
                    else if (op == 4) vec.push_back(NUM(N0.first * N1.second, N0.second * N1.first));
                    else vec.push_back(NUM(N0.second * N1.first, N0.first * N1.second));
                    flag |= can24(vec, l + 2, r + 1);
                    vec.pop_back();
                }
                vec[l] = L0, vec[l + 1] = L1, vec[i] = N0, vec[j] = N1;
            }
        }
        return flag;
    }
};