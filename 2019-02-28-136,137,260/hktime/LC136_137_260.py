#!/usr/bin/env python  
#-*- coding:utf-8 _*-  
""" 
@author:hktime
@time: 2019/02/28

#
# Be water, my friend.
#
"""

#LC136
"""
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        a = 0
        for i in nums:
            a = a ^ i
        return a
"""
#LC137
"""
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        return int((3 * sum(set(nums)) - sum(nums))/2)
"""
#LC260
"""
class Solution:
    def singleNumber(self, nums: List[int]) -> List[int]:
        xor = 0
        for i in nums:
            xor ^= i
        val = 1
        while (val & xor) == 0:
            val <<= 1
        a, b = 0, 0
        for i in nums:
            if i & val :
                a ^= i
            else:
                b ^= i
        return a, b
"""