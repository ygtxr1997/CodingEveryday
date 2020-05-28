class Solution {
public:
    int subarraysDivByK(vector<int>& A, int K) {
        unordered_map<int, int> hash;
        int n = A.size();
        hash[0] = 1;
        int sum = 0, ans = 0;
        for (int i = 0; i < n; ++i) {
            sum = (((sum + A[i]) % K) + K) % K; // 保证非负
            ans += hash[sum];
            hash[sum]++;
        }
        return ans;
    }
};