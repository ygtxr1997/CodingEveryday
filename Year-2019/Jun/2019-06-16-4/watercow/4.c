// 扁扁熊用户的题解把我秀哭了
// https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/4-xun-zhao-liang-ge-you-xu-shu-zu-de-zhong-wei-shu/

class Solution {
public:
	double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
		int n = nums1.size();
		int m = nums2.size();

		// 保证短的数组在第一个参数位置
		if (n > m) {
			return findMedianSortedArrays(nums2, nums1);
		}

		// LMaxi为第i个数组割后的左元素。RMini为第i个数组割后的右元素
		int Lmax1, Lmax2, Rmin1, Rmin2;
		// Ci 为第i个数组的割,
		// 如C1为2时表示第1个数组只有2个元素
		int c1, c2, lo = 0;
		// 虚拟加了'#'所以数组1是2*n长度
		int hi = 2 * n;
		
		// 二分法
		while (lo <= hi) {
			c1 = (lo + hi) / 2;
			c2 = m + n - c1;

			Lmax1 = (c1 == 0) ? INT_MIN : nums1[(c1 - 1) / 2];
			Lmax2 = (c2 == 0) ? INT_MIN : nums2[(c2 - 1) / 2];
			Rmin1 = (c1 == 2 * n) ? INT_MAX : nums1[c1 / 2];
			Rmin2 = (c2 == 2 * m) ? INT_MAX : nums2[c2 / 2];

			if (Lmax1 > Rmin2) {
				hi = c1 - 1;
			}
			else if (Lmax2 > Rmin1) {
				lo = c1 + 1;
			}
			else break;
		}
		return (max(Lmax1, Lmax2) + min(Rmin1, Rmin2)) / 2.0;
	}
};
