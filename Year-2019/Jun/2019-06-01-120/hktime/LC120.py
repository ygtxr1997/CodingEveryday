# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-07-24 11:09:33
# @Last Modified by:   HK
# @Last Modified time: 2019-07-24 13:31:46

class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if len(triangle) == 0:
            return 0
        res = triangle[-1]
        
        for i in range(len(triangle)-2,-1,-1):
            for j in range(len(triangle[i])):
                res[j] = min(res[j],res[j+1]) + triangle[i][j] #比较的是路径和，而不是数组元素值
        return res[0]