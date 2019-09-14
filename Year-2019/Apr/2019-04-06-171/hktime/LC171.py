# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-09-14 10:14:09
# @Last Modified by:   HK
# @Last Modified time: 2019-09-14 10:14:20


class Solution:
    def titleToNumber(self, s: str) -> int:
        ans = 0
        for c in s:
            ans *= 26
            ans += ord(c) -ord('A') + 1
        return ans