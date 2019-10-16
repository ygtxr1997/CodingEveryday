# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-10-16 17:08:31
# @Last Modified by:   HK
# @Last Modified time: 2019-10-16 17:08:35


from collections import deque

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if amount == 0:
            return 0
        List = set()
        List.add(amount)
        queue = [amount]
        step = 0
        while queue != []:
            step += 1
            que = []
            for cu in queue:
                for coin in coins:
                    per = cu - coin
                    if per in List:
                        continue
                    elif per == 0:
                        return step
                    else:
                        if(per > 0):
                            que.append(per)
                            List.add(per)
                queue = que
        return -1