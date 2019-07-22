# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-07-17 09:52:15
# @Last Modified by:   HK
# @Last Modified time: 2019-07-17 09:52:20


class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        r, n = [[n**2]], n**2
        while n > 1:
            n, r = n - len(r), [[*range(n - len(r), n)]] + [*zip(*r[::-1])]
        return r
