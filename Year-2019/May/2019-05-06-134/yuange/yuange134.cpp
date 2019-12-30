// 8ms, 70%
class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        int n = gas.size();
        vector<int> equal(n);
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            equal[i] = gas[i] - cost[i];
            sum += equal[i];
        }
        if (sum < 0) return -1;
        int start = 0;
        int cur = 0;
        for (int i = 0; i < n; ++i) {
            cur += equal[i];
            if (cur < 0) {
                start = i + 1;
                cur = 0;
            }
        }
        return start;
    }
};