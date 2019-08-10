# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-08-10 11:27:57
# @Last Modified by:   HK
# @Last Modified time: 2019-08-10 11:28:11


class Solution:
    def fib(self, N: int) -> int:
        if N == 0:
            return 0
        elif N == 1:
            return 1
        # if N >=2:
        #     # 递归了解一下
        #     return self.fib(N-1) + self.fib(N-2)
        a, b = 0, 1
        for i in range(N - 1):
            a, b = b, a + b
        return b
