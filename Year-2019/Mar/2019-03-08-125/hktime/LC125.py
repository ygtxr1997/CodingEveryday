#!/usr/bin/env python  
#-*- coding:utf-8 _*-  
""" 
@author:hktime
@time: 2019/03/08

#
# Be water, my friend.
#
"""

class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = ''.join(filter(str.isalnum,s)).lower()
        return s == s[::-1]