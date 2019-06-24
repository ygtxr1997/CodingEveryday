# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-06-20 19:11:11
# @Last Modified by:   HK
# @Last Modified time: 2019-06-21 10:50:28


class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        # 先排序，然后遍历，内部使用双指针
        nums.sort()
        distance = abs(nums[0] + nums[1] + nums[2] - target)
        ret = 0
        for i in range(len(nums)):
            start = i + 1
            end = len(nums) - 1
            while start < end:
                if abs(nums[i] + nums[start] + nums[end] - target) <= distance:
                    distance = abs(nums[i] + nums[start] + nums[end] - target)
                    ret = nums[i] + nums[start] + nums[end]
                if nums[i] + nums[start] + nums[end] == target:
                    return nums[i] + nums[start] + nums[end]
                elif nums[i] + nums[start] + nums[end] < target:
                    start += 1
                else:
                    end -= 1
        return ret
