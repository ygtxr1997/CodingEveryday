# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-07-17 12:56:41
# @Last Modified by:   HK
# @Last Modified time: 2019-07-17 12:57:10


class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        station = [0] * 1001
        for trip in trips:
            for i in range(trip[1], trip[2]):
                station[i] += trip[0]
        for stat in station:
            if stat > capacity:
                return False
        return True
