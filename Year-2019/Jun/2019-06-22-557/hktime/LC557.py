# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-06-25 20:52:30
# @Last Modified by:   HK
# @Last Modified time: 2019-06-25 20:52:45


class Solution:
    def reverseWords(self, s: str) -> str:
        sList = s.split(' ')
        for i, word in enumerate(sList):
            sList[i] = word[::-1]
        return " ".join(sList)
