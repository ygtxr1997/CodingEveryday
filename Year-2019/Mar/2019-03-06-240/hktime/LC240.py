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
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if len(matrix) == 0 or len(matrix[0]) == 0:
            return False
        m, n = len(matrix) - 1, 0
        row = 0
        while m >= 0 and n < len(matrix[0]):
            if matrix[m][n] == target:
                return True
            elif matrix[m][n] >= target:
                m -= 1
            else:
                n += 1    
        return False