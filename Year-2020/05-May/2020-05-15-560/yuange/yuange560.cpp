class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        unordered_map<int, int> hash;
        hash[0] = 1;
        int n = nums.size(), ans = 0;
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            // 前缀和之差即一段连续区间
            // 每次找到以i结尾的连续区间, 若符合则加入ans
            if (hash.count(sum - k) != 0) ans += hash[sum - k];
            hash[sum]++;
        }
        return ans;
    }
};