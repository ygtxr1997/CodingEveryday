#!/usr/bin/env python  
#-*- coding:utf-8 _*-  
""" 
@author:hktime
@time: 2019/03/04

#
# Be water, my friend.
#
"""

class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        begin = nums[0]
        count = 1
        for value in nums:
            if value == begin:
                count += 1
            else:
                count -= 1
            if count == 0:
                begin = value
                count = 1
        return begin