# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-09-30 10:45:48
# @Last Modified by:   HK
# @Last Modified time: 2019-09-30 10:45:54


class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        slow = 0
        fast = 0
        while True:
            slow = nums[slow]
            fast = nums[nums[fast]]
            if slow == fast:
                break
        finder = 0
        while True:
            slow = nums[slow]
            finder = nums[finder]
            if slow == finder:
                return finder
        