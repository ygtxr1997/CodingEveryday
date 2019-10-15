# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-10-15 16:12:43
# @Last Modified by:   HK
# @Last Modified time: 2019-10-15 16:12:46


from collections import deque

class Solution:
    def numSquares(self, n: int) -> int:
        if n == 0 :
            return 0
        queue = deque([n])
        step = 0
        visited = set()
        while queue:
            step += 1
            l = len(queue)
            for _ in range(l):
                tmp = queue.pop()
                for i in range(1, int(tmp ** 0.5) + 1):
                    diff = tmp - i ** 2
                    if diff == 0:
                        return step
                    if diff not in visited:
                        visited.add(diff)
                        queue.appendleft(diff)
        return step