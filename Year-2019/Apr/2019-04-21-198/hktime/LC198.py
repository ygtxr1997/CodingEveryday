# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-10-14 10:14:31
# @Last Modified by:   HK
# @Last Modified time: 2019-10-14 10:14:33


class Solution:
    def rob(self, nums: List[int]) -> int:
        if nums == []:
            return 0
        if len(nums) <= 2:
            return max(nums)
        dp = [0] * len(nums)
        dp[0] = nums[0]
        dp[1] = max(nums[1],nums[0])
        for i in range(2, len(nums)):
            dp[i] = max(dp[i-2] + nums[i], dp[i-1])
        return max(dp)