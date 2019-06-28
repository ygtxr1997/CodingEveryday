# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-06-28 21:01:34
# @Last Modified by:   HK
# @Last Modified time: 2019-06-28 21:08:10


class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        # 方法不错，就是有点难理解，mark一下
        retList = []
        if matrix == []:
            return retList
        retList.extend(matrix[0])
        newList = [reversed(i) for i in matrix[1:]]
        if newList == []:
            return retList
        r = self.spiralOrder([i for i in zip(*newList)])
        retList.extend(r)
        return retList
