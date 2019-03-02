#!/usr/bin/env python  
#-*- coding:utf-8 _*-  
""" 
@author:hktime
@time: 2019/03/02

#
# Be water, my friend.
#
"""

class Solution:
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        # 容纳的水
        water_max = 0
        start, end = 0, len(height) - 1
        while(start < end):
            h = min(height[start], height[end])
            water = (end - start) * h
            if water > water_max:
                water_max = water
            while (height[start] <= h and start < end): start += 1
            while (height[end] <= h and end > start): end -= 1
        return water_max