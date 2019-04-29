// 摆动排序，类似三分partition算法
// nth_element() 函数使得，[begin, k) 的元素都不大于 [k, end) 的元素
// 因为有可能有相等元素分布在 mid 的两侧，所以在遍历数组时需要用 i、j、k 三个变量记录位置，
// 并且考虑大于、小于、等于三种情况
class Solution {
public:
    void wiggleSort(vector<int>& nums) {
        int n = nums.size();
        nth_element(nums.begin(), nums.begin() + n / 2, nums.end());
        int mid = *(nums.begin() + n / 2);
        
        int i = (n - 1) / 2 * 2, j = i, k = 1;
        for (int c = 0; c < n; ++c) {
            if (nums[j] > mid) {
                swap(nums[j], nums[k]);
                k += 2;
            } else if (nums[j] < mid) {
                swap(nums[i], nums[j]);
                i -= 2;
                j -= 2;
                if (j < 0) j = n / 2 * 2 - 1;
            } else {
                j -= 2;
                if (j < 0) j = n / 2 * 2 - 1;
            }
        }
    }
};
