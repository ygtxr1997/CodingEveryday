# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-09-27 10:11:26
# @Last Modified by:   HK
# @Last Modified time: 2019-09-27 10:11:36


class Solution:
    def wiggleSort(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        nums.sort(reverse=True)
        # nums[1::2],取奇数位置元素
        nums[::2], nums[1::2] = nums[len(nums)//2:], nums[:len(nums)//2] 