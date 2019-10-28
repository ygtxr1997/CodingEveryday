# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-10-28 11:05:08
# @Last Modified by:   HK
# @Last Modified time: 2019-10-28 11:05:13


class Solution:
    def fractionToDecimal(self, numerator: int, denominator: int) -> str:
        if numerator == 0: return "0"
        res = []
        # 首先判断结果正负, 异或作用就是 两个数不同 为 True 即 1 ^ 0 = 1 或者 0 ^ 1 = 1
        if (numerator > 0) ^ (denominator > 0):
            res.append("-")
        numerator, denominator = abs(numerator), abs(denominator)
        # 判读到底有没有小数
        a, b = divmod(numerator, denominator)
        res.append(str(a))
        # 无小数
        if b == 0:
            return "".join(res)
        res.append(".")
        # 处理余数
        # 把所有出现过的余数记录下来
        loc = {b: len(res)}
        while b:
            b *= 10
            a, b = divmod(b, denominator)
            res.append(str(a))
            # 余数前面出现过,说明开始循环了,加括号
            if b in loc:
                res.insert(loc[b], "(")
                res.append(")")
                break
            # 在把该位置的记录下来
            loc[b] = len(res)
        return "".join(res)