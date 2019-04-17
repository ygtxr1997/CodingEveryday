// 时间复杂度是O(N^2*log(N))，256ms，58%，效率比较低
class Solution {
public:
    int fourSumCount(vector<int>& A, vector<int>& B, vector<int>& C, vector<int>& D) {
        int count = 0;
        unordered_map<int, int> sums;
        for(int i : A) for(int j : B) sums[i+j]++;
        for(int i : C) for(int j : D) count+=sums[-(i+j)];
        return count;
    }
};
