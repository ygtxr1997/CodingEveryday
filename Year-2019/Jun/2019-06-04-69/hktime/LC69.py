# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-08-05 13:30:19
# @Last Modified by:   HK
# @Last Modified time: 2019-08-05 14:33:59


class Solution:
    def mySqrt(self, x: int) -> int:
        # # 牛顿迭代法
        # if x <= 1:
        #     return x
        # # 对一个非负数，其平方根不会大于 x//2 + 1
        # ret = x//2 + 1
        # # 从右侧逼近
        # while ret > x / ret:
        #     ret= (ret + x / ret) // 2
        # return int(ret)

        # 二分法,又麻烦又容易出错，各种边界条件
        if x <= 1:
            return x
        left, right = 1, x//2
        while left < right:
            # 取右中位数
            mid = left + (right - left + 1)//2
            square = mid * mid
            if square > x:
                right = mid - 1
            else:
                left = mid
        return left
