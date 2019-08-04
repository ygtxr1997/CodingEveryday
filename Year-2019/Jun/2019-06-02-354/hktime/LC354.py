# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-07-24 13:32:15
# @Last Modified by:   HK
# @Last Modified time: 2019-08-04 16:18:18


class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        # O(N2)
        # if envelopes == []:
        #     return 0
        # envelopes.sort()
        # dp = [1] * len(envelopes)
        # for i in range(1, len(envelopes)):
        #     for j in range(i):
        #         if envelopes[i][0] > envelopes[j][0] and envelopes[i][1] > envelopes[j][1]:
        #             dp[i] = max(dp[i], dp[j] + 1)
        # return max(dp)
        # 动态规划
        # size = len(envelopes)
        # if size < 2:
        #     return size
        # envelopes = sorted(envelopes, key=lambda x: (x[0], -x[1]))
        # tails = [0] * size
        # heights = [x[1] for x in envelopes]
        # size = 0
        # for height in heights:
        #     left = 0
        #     right = size
        #     while left < right:
        #         mid = (left + right) // 2
        #         if tails[mid] < height:
        #             left = mid + 1
        #         else:
        #             right = mid
        #     tails[left] = height
        #     size = max(size, left + 1)
        # return size
        # 二分查找
        size = len(envelopes)
        if size < 2:
            return size
        envelopes = sorted(envelopes, key=lambda x: (x[0], -x[1]))
        tail = [envelopes[0][1]]
        heights = [x[1] for x in envelopes]
        for i in range(1, len(heights)):
            if heights[i] > tail[-1]:
                tail.append(heights[i])
                continue
            left, right = 0, len(tail) - 1
            while left < right:
                mid = left + (right - left) // 2
                if tail[mid] < heights[i]:
                    left = mid + 1
                else:
                    right = mid
            tail[left] = heights[i]
        return len(tail)
