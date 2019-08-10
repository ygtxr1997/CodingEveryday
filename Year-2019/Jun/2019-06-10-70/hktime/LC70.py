# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-08-10 11:54:12
# @Last Modified by:   HK
# @Last Modified time: 2019-08-10 11:55:00
# from functools import lru_cache


class Solution:
    # 设个缓存也太秀了
    # @lru_cache(10**8)
    def climbStairs(self, n: int) -> int:

        # if n <= 2:
        #     return n
        # if n > 2:
        # 直接递归，计算有点复杂
        #     return self.climbStairs(n-1) + self.climbStairs(n-2)
        # 斐波那契数列问题
        if n <= 2:
            return n
        a, b = 1, 2
        for i in range(n-2):
            a, b = b, a+b
        return b
