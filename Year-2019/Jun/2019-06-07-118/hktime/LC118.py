# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-08-09 10:45:04
# @Last Modified by:   HK
# @Last Modified time: 2019-08-09 10:53:50


class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        #         if numRows == 0:
        #             return []
        #         retTri = []
        #         for i in range(1,numRows+1):
        #             if i == 1:
        #                 retTri.append([1])
        #                 continue
        #             if i == 2:
        #                 retTri.append([1,1])
        #                 continue
        #             listNow = []
        #             for j in range(i):
        #                 if j == 0 || j == i-1:
        #                     listNow.append(1)
        #                     continue
        #                 listNow.append(retTri[i-2][j-1] + retTri[i-2][j])

        #             retTri.append(listNow)
        #         return retTri
        ret = []
        for i in range(numRows):
            # 下面这行比较巧妙
            now = [1] * (i + 1)
            if i >= 2:
                for n in range(1, i):
                    now[n] = pre[n - 1] + pre[n]
            ret += [now]
            pre = now
        return ret
