# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-07-22 08:53:09
# @Last Modified by:   HK
# @Last Modified time: 2019-07-22 08:53:41


class Solution:
    def duplicateZeros(self, arr: List[int]) -> None:
        """
        Do not return anything, modify arr in-place instead.
        """
        # i = 0
        # while i < len(arr):
        #     if arr[i] == 0:
        #         if i + 1 < len(arr):
        #             arr.pop()
        #             arr.insert(i+1,0)
        #             i += 2
        #             continue
        #     i += 1
        tmp = arr[:]
        index = 0
        for x in tmp:
            if x == 0 and index < len(tmp):
                arr[index] = x
                index += 1
            if index < len(tmp):
                arr[index] = x
                index += 1
