# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-06-23 10:19:25
# @Last Modified by:   HK
# @Last Modified time: 2019-06-24 20:15:58


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if nums == []:
            return 0
        length = 1
        for i in range(1, len(nums)):
            if nums[i] != nums[i - 1]:
                nums[length] = nums[i]
                length += 1
        return length
