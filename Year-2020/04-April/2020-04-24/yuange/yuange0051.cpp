// 用归并排序的方法计算逆序对，逆序对是归并排序的副产物
// 利用数组部分有序的性质
class Solution {
    static const int maxn = 50010;
    int vec[maxn];
    int tmp[maxn];
public:
    int mergeSort(int l, int r) {
        if (l >= r) return 0;
        int mid = (l + r) / 2;
        int cnt = mergeSort(l, mid) + mergeSort(mid + 1, r);
        int i = l, j = mid + 1, k = 0;
        while (i <= mid && j <= r) {
            if (vec[i] <= vec[j]) {
                cnt += (j - (mid + 1));
                tmp[k] = vec[i++];
            } else {
                tmp[k] = vec[j++];
            }
            k++;
        }
        // 处理剩余部分
        for (int t = i; t <= mid; ++t) { // 左边
            tmp[k++] = vec[t];
            cnt += (j - (mid + 1));
        }
        for (int t = j; t <= r; ++t) { // 右边
            tmp[k++] = vec[t];
        }
        memcpy(vec + l, tmp, (r - l + 1) * sizeof(int));
        return cnt;
    }

    int reversePairs(vector<int>& nums) {
        memset(vec, 0, sizeof(vec));
        for (int i = 0; i < nums.size(); ++i) vec[i] = nums[i];
        return mergeSort(0, nums.size() - 1);
    }
};