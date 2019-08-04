# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-08-03 22:42:04
# @Last Modified by:   HK
# @Last Modified time: 2019-08-03 22:42:37


# class Solution:
#     def searchRange(self, nums: List[int], target: int) -> List[int]:
#         if target not in nums:
#             return [-1,-1]
#         left = nums.index(target)
#         nums.reverse()
#         right = len(nums) - nums.index(target) -1
#         return [left, right]


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if nums == []:
            return [-1, -1]
        res = [-1, -1]
        left, right = 0, len(nums) - 1
        while(left < right):
            mid = left + (right - left) // 2
            if nums[mid] >= target:
                right = mid
            else:
                left = mid + 1
        if nums[left] != target:
            return res
        res[0] = left
        right = len(nums)
        while(left < right):
            mid = left + (right - left) // 2
            if nums[mid] <= target:
                left = mid + 1
            else:
                right = mid
        res[1] = left - 1
        return res
