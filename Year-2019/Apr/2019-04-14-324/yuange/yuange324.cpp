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
        
        // k : 从左至右第一个波峰位置(奇数位)，需要保存极大值；处理前 n[k] <= mid
        // i : 从右至左第一个波谷位置(偶数位)，需要保存极小值；处理前 n[i] >= mid
        // j : 如果 n[j] > mid，那么 n[j] 就是符合波峰的元素
        //     如果 n[j] = mid，那么 j 必须继续向左找到符合波谷的元素
        //     如果 n[j] < mid，那么 n[j] 就是符合波谷的元素
        //     当 j < 0 时，再重新回到右侧的奇数位
        // c : c = n，保证每个元素都被遍历过
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
