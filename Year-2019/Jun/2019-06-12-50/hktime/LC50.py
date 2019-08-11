# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-08-11 10:41:39
# @Last Modified by:   HK
# @Last Modified time: 2019-08-11 10:41:45


class Solution:
    def myPow(self, x: float, n: int) -> float:
        # O(n)
        # if n == 0:
        #     return 1
        # if n > 0:
        #     y = x
        #     for i in range(1,n):
        #         y = x * y
        #     return y
        # if n < 0:
        #     y = 1.0/x
        #     z = y
        #     for i in range(1,-n):
        #         z = y*z
        #     return z
        # O(logn)
        res = 1.0
        i = abs(n)
        while i != 0:
            if i % 2:
                res *= x
            x *= x
            i //= 2
        return 1 / res if n < 0 else res
