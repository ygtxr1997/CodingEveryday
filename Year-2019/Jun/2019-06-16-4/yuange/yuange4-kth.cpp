// 求第K大的元素，每次排除K/2个元素
// 16ms，93%
class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int m = nums1.size(); 
        int n = nums2.size();
        int l = (m + n + 1) / 2; // 将奇数偶数归为一种处理方式
        int r = (m + n + 2) / 2; // 如果是奇数则求两次一样的值
        return 0.5 * (findKth(nums1, 0, m - 1, nums2, 0, n - 1, l) + findKth(nums1, 0, m - 1, nums2, 0, n - 1, r));
    }
    
    // 求指定范围(nums1:[b1,e1]和nums2:[b2,e2])内第k大的数
    int findKth(vector<int>& nums1, int b1, int e1, vector<int>& nums2, int b2, int e2, int k) {
        int len1 = e1 - b1 + 1;
        int len2 = e2 - b2 + 1;
        // 始终让nums2更长
        if (len1 > len2) return findKth(nums2, b2, e2, nums1, b1, e1, k);
        if (len1 == 0) return nums2[b2 + k - 1];
        if (k == 1) return min(nums1[b1], nums2[b2]);
        
        int i = b1 + min(len1, k / 2) - 1;
        int j = b2 + min(len2, k / 2) - 1;
        // nums1较大，则删除nums2中j-b2+1个元素
        // nums2较大，则删除nums1中i-b1+1个元素
        if (nums1[i] > nums2[j]) return findKth(nums1, b1, e1, nums2, j + 1, e2, k - (j - b2 + 1));
        else return findKth(nums1, i + 1, e1, nums2, b2, e2, k - (i - b1 + 1));
    }
};