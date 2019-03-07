#!/usr/bin/env python  
#-*- coding:utf-8 _*-  
""" 
@author:hktime
@time: 2019/03/02

#
# Be water, my friend.
#
"""

#LC416
class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        """
        :type nums: List[int]
        :rtype: bool
        """
        s = sum(nums)
        if s % 2:
            return False
        s //= 2
        if max(nums) > s:
            return False
        # 先排序
        nums.sort(reverse=True)
        # 再使用迭代
        return self.func(nums,s) or False
    
    def func(self,nums,target):
        if target is 0:
            return True
        flag = False
        for i in range(len(nums)):
            if nums[i] > target:
                continue
            flag = self.func(nums[i+1:],target-nums[i])
            if flag:
                return flag

#LC410
#pass
