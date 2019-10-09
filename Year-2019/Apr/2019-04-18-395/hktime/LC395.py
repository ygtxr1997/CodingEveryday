# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-10-09 16:24:40
# @Last Modified by:   HK
# @Last Modified time: 2019-10-09 16:24:45


class Solution:
    def longestSubstring(self, s: str, k: int) -> int:
        # 分治算法
        if not s:
            return 0
        for c in set(s):
            if s.count(c) < k:
                return max(self.longestSubstring(t, k) for t in s.split(c))
        return len(s)
        