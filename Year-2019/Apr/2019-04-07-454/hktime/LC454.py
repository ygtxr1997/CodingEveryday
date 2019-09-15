# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-09-15 10:11:02
# @Last Modified by:   HK
# @Last Modified time: 2019-09-15 10:11:13


class Solution:
    def fourSumCount(self, A: List[int], B: List[int], C: List[int], D: List[int]) -> int:
        count = 0
        # 字典表示A+B的值和出现次数
        AB = {}
        for i in A:
            for j in B:
                if i + j in AB:
                    AB[i+j] += 1
                else:
                    AB[i+j] = 1
        for i in C:
            for j in D:
                if -(i+j) in AB:
                    count += AB[-(i+j)]
        return count