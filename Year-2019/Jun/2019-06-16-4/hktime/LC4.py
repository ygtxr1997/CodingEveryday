# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-06-20 18:29:43
# @Last Modified by:   HK
# @Last Modified time: 2019-06-20 18:30:40


class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        # 得到数组长度
        n1, n2 = len(nums1), len(nums2)
        n1_start, n2_start = 0, 0
        left, right = -1, -1
        # 遍历总数组长度的一半
        for i in range((n1 + n2) // 2 + 1):
            left = right
            # 考虑什么情况下给right赋n1中的值
            if n1_start < n1 and (n2_start >= n2 or nums1[n1_start] < nums2[n2_start]):
                right = nums1[n1_start]
                n1_start += 1
            else:  # 给right赋n2中的值
                right = nums2[n2_start]
                n2_start += 1
        # 总长度为偶数
        if (n1 + n2) & 1 == 0:
            return (left + right) / 2
        else:
            return right
