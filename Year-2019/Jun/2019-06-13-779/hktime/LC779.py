# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-06-14 10:42:37
# @Last Modified by:   HK
# @Last Modified time: 2019-06-17 18:44:48


class Solution:
    def kthGrammar(self, N: int, K: int) -> int:
        if N == 1:
            return 0
        if N == 2:
            return 0 if K == 1 else 1
        preLength = 2 ** (N - 2)
        # 第N行的前一半等于上一行，后一半等于上一行的逆
        if K <= preLength:
            return self.kthGrammar(N - 1, K)
        else:
            return 1 - self.kthGrammar(N - 1, K - preLength)

# 奇技淫巧，interesting
# class Solution:
#     def kthGrammar(self, N: int, K: int) -> int:
#         return bin(K-1).count('1') %2
