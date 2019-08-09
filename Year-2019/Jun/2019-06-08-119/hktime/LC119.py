# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-08-09 10:58:29
# @Last Modified by:   HK
# @Last Modified time: 2019-08-09 10:58:34


class Solution:
    def getRow(self, rowIndex: int) -> List[int]:
        # for i in range(rowIndex + 1):
        #     now = [1] * (i + 1)
        #     if i >= 2:
        #         for j in range(1,i):
        #             now[j] = pre[j-1] + pre[j]
        #     pre = now
        # return now
        # 这个有点秀，用了O(k)空间
        i, result = 0, [1]
        while i < rowIndex:
            result = [1] + [result[x] + result[x + 1]
                            for x in range(len(result) - 1)] + [1]
            i += 1
        return result
