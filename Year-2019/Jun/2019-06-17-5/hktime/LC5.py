# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-06-17 18:57:06
# @Last Modified by:   HK
# @Last Modified time: 2019-06-17 18:59:55


class Solution:
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        # Manacher's Algorithm
        # 添加#
        if len(s) < 2 or s == s[::-1]:
            return s

        # 中心拓展算法
        max_len = 1  # 回文子串长度
        start = 0  # 回文子串起始位置
        for i in range(1, len(s)):
            even = s[i - max_len: i + 1]  # 偶数回文子串
            odd = s[i - max_len - 1: i + 1]  # 奇数回文子串
            if i - max_len - 1 >= 0 and odd == odd[::-1]:
                start = i - max_len - 1
                max_len += 2
                continue
            if i - max_len >= 0 and even == even[::-1]:
                start = i - max_len
                max_len += 1
        return s[start: start + max_len]
