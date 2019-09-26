# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-09-26 10:21:00
# @Last Modified by:   HK
# @Last Modified time: 2019-09-26 10:21:09


import functools
class Solution:
    def strCmp(self, s1, s2):
        if s1 + s2 > s2 + s1:
            return 1
        return -1
    
    def largestNumber(self, nums: List[int]) -> str:
        s = set(nums)
        if len(s) == 1 and 0 in s: # 处理[0,0]这种用例
            return "0"
        nums = sorted([str(n) for n in nums],key=functools.cmp_to_key(self.strCmp), reverse=True )
        return "".join(nums)