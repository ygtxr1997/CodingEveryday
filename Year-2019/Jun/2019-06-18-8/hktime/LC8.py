# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-06-20 19:09:50
# @Last Modified by:   HK
# @Last Modified time: 2019-06-20 19:10:51


class Solution:
    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        # 判断是否为空
        if str == '':
            return 0
        INT_MAX = 2147483647
        INT_MIN = -2147483648
        start, end = len(str), len(str)
        nums = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '+']
        num = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
        for i in range(len(str)):
            if str[i] == ' ':
                continue
            if str[i] in nums:
                start = i
                break
            else:
                return 0
        for i in range(i + 1, len(str)):
            if str[i] in num:
                continue
            else:
                end = i
                break
        if str[start:end] == '-' or str[start:end] == '+' or str[start:end] == '':
            return 0
        res = int(str[start:end])
        if res > INT_MAX:
            return INT_MAX
        elif res < INT_MIN:
            return INT_MIN
        else:
            return int(str[start:end])
