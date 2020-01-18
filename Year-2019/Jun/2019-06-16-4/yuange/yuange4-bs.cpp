// 二分切割数组
// 20ms，78%
class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int m = nums1.size();
        int n = nums2.size();
        if (m > n) return findMedianSortedArrays(nums2, nums1); // 始终让nums2较长
        int iMin = 0, iMax = m;
        // nums1: 0 ......... i-1 | i ... m-1
        // nums2:       0 ... j-1 | j ................. n-1
        while (iMin <= iMax) { // 二分查找i的位置，分割线左边始终有一半的数字的同时，使[i-1]<=[j]且[j-1]<=[i]
            int i = (iMin + iMax) / 2;
            int j = (m + n + 1) / 2 - i; // j的位置同时考虑了奇偶数的情况
            if (j != 0 && i != m && nums2[j - 1] > nums1[i]) iMin = i + 1;
            else if (i != 0 && j != n && nums1[i - 1] > nums2[j]) iMax = i - 1;
            else { // 满足条件，找到了中位数的位置，中位数mid∈{nums1[i-1],nums[i],nums[j-1],nums[j]}
                   // 但还要分情况讨论到底是哪一个
                int maxLeft = 0;
                if (i == 0) maxLeft = nums2[j - 1];
                else if (j == 0) maxLeft = nums1[i - 1];
                else maxLeft = max(nums1[i - 1], nums2[j - 1]);
                if ((m + n) % 2) return maxLeft; // 奇数不用考虑右边
                
                int minRight = 0;
                if (i == m) minRight = nums2[j];
                else if (j == n) minRight = nums1[i];
                else minRight = min(nums1[i], nums2[j]);
                
                return (maxLeft + minRight) * 0.5;
            }
        }
        return 0.0;
    }
};