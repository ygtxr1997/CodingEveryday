#!/usr/bin/env python  
#-*- coding:utf-8 _*-  
""" 
@author:watercow 
@license: Apache Licence 
@file: test.py 
@time: 2019/03/01
@site:  
@software: PyCharm 

# code is far away from bugs with the god animal protecting
    I love animals. They taste delicious.
              ┏┓      ┏┓
            ┏┛┻━━━┛┻┓
            ┃      ☃      ┃
            ┃  ┳┛  ┗┳  ┃
            ┃      ┻      ┃
            ┗━┓      ┏━┛
                ┃      ┗━━━┓
                ┃  神兽保佑    ┣┓
                ┃　永无BUG！   ┏┛
                ┗┓┓┏━┳┓┏┛
                  ┃┫┫  ┃┫┫
                  ┗┻┛  ┗┻┛ 
"""

# 0-1背包问题的变化而已
# 在n个物品中选出一定物品，填满sum/2的背包
# 甚至不牵扯价值
# 不同的是必须填满，而不是小于等于

# F(n, C)考虑将n个物品填满容量为C的背包
# F(i, c) = F(i-1, c) || F(i-1, c-w(i))

class Solution(object):
    def __init__(self):
        # memery[i][c]表示使用索引为[0,...,i]的这些元素能否可以完全填充容量为c的背包
        # -1:未计算， 0:不能 1:能
        self.memery = []

    def canPartition(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        sum = 0
        for i in nums:
            sum += i

        # 不能平分直接判断不可能完成
        if sum%2 != 0:
            return False

        # 初始化memery
        self.memery = [[-1]*(sum/2+1)] * len(nums)


        return self.F(nums, len(nums) - 1, sum/2)


    def F(self, nums, index, C):
        if not C:
            return True

        if C < 0 or index < 0 :
            return False

        if self.memery[index][C] != -1:
            return self.memery[index][C]

        self.memery[index][C] = (self.F(nums, index-1, C) or self.F(nums, index-1, C-nums[index]))
        return self.memery[index][C]

if __name__ == '__main__':
    memery = []
    for i in range(6):
        memery.append(-1)
    memery = [memery] * 3
    print(memery)