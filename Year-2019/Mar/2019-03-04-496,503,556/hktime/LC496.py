#!/usr/bin/env python  
#-*- coding:utf-8 _*-  
""" 
@author:hktime
@time: 2019/03/04

#
# Be water, my friend.
#
"""

#单调栈的应用
#单调栈就是指栈内元素保持一定单调性的栈
#栈满足后进先出的特点
#单调栈何时用： 为任意一个元素找左边和右边第一个比自己大/小的位置，用单调栈
#用递增单调栈还是递减单调栈：递减栈会剔除波谷，留下波峰；递增栈剔除波峰，留下波谷

class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        stack = []
        larger = dict()
        for n2 in nums2:
            while len(stack) and stack[-1] < n2:
                larger[stack.pop()] = n2
            else:
                stack.append(n2)
        for i in range(len(nums1)):
            nums1[i] = larger.get(nums1[i], -1)
        return nums1
        