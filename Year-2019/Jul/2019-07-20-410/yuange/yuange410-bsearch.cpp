// 结果的范围只可能是[max, sum]，二分查找所有可能的取值
// 如果分组数>m，则取值过小，缩小至右半部分取值范围；
// 如果分组数<=m，则取值过大，缩小至左半部分取值范围；
// 当且仅当取值范围仅为一个数字时，输出结果
class Solution {
public:
    int splitArray(vector<int>& nums, int m) {
        long left = INT_MIN, right = 0;
        for (auto n : nums) {
            left = n > left ? n : left;
            right += n;
        }
    while (left != right) {
            long k = 1, cur_sum = 0;
            long mid = (left + right) / 2;
            for (auto n : nums) {
                if (cur_sum + n > mid) { k++; cur_sum = 0; }
                cur_sum += n;
            }
            if (k > m) left =  mid + 1;
            else right = mid;
        }
        return left;
    }
};