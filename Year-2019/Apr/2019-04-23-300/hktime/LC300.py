# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-08-01 14:04:10
# @Last Modified by:   HK
# @Last Modified time: 2019-08-01 14:26:40

#最长上升子序列，经典的动态规划问题
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        size = len(nums)
        if size <= 1:
            return size
        dp = [1] * size
        for i in range(1, size):
            for j in range(0, i):
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i], 1+dp[j])
        return max(dp)
