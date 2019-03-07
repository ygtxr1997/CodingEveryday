// 直接从nums1的m+n-1位开始赋值比较
// 从后向前依次填充nums1

class Solution {
public:
	void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {

		int last_index = n + m - 1;
		while (last_index >= 0) {
			if (n == 0) break;

			else if (m == 0) {
				for (int i = 0; i < n; i++) {
					nums1[i] = nums2[i];
				}
				break;
			}

			else if (nums1[m - 1] >= nums2[n - 1]) {
				nums1[last_index--] = nums1[m-- - 1];
			}

			else if (nums1[m - 1] < nums2[n - 1]) {
				nums1[last_index--] = nums2[n-- - 1];
			}
		}
	}
};