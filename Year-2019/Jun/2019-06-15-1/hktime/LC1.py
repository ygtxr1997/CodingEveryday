# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-06-17 18:43:17
# @Last Modified by:   HK
# @Last Modified time: 2019-06-17 18:43:47


class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        dict = {}
        for i in range(len(nums)):
            if target - nums[i] in dict:
                return[dict[target - nums[i]], i]
            dict[nums[i]] = i
