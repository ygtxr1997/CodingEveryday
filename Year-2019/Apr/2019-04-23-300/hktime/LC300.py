# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-08-01 14:04:10
# @Last Modified by:   HK
# @Last Modified time: 2019-08-04 16:11:18

#最长上升子序列，经典的动态规划问题
# class Solution:
#     def lengthOfLIS(self, nums: List[int]) -> int:
#         size = len(nums)
#         if size <= 1:
#             return size
#         dp = [1] * size
#         for i in range(1, size):
#             for j in range(0, i):
#                 if nums[i] > nums[j]:
#                     dp[i] = max(dp[i], 1+dp[j])
#         return max(dp)
#O(NlogN) 动态规划 + 二分查找
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        size = len(nums)
        if size < 2:
            return size
        dp = [nums[0]]
        for i in range(1, len(nums)):
            if nums[i] > dp[-1]:
                dp.append(nums[i])
                continue
            left, right = 0, len(dp) - 1
            while left < right:
                mid = left + (right - left) // 2
                if dp[mid] < nums[i]:
                    left = mid + 1
                else:
                    right = mid
            dp[left] = nums[i]
        return len(dp)