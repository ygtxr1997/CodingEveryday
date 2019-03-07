#!/usr/bin/env python  
#-*- coding:utf-8 _*-  
""" 
@author:watercow 
@license: Apache Licence 
@file: main.py 
@time: 2019/02/27
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


# Definition for a point.
class Point(object):
    def __init__(self, a=0, b=0):
        self.x = a
        self.y = b

class Solution(object):
    def maxPoints(self, points):
        """
        :type points: List[Point]
        :rtype: int
        """
        if not points:
            return 0

        if len(points) == 1:
            return 1

        point_dict = {}

        # 填充map
        for PointA in points:
            if PointA not in point_dict:
                point_dict[PointA] = {}

            for PointB in points:
                if PointA != PointB:
                    gradient = self.get_gradient_by_gcd(PointA, PointB)
                    if gradient not in point_dict[PointA]:
                        point_dict[PointA][gradient] = []

                    point_dict[PointA][gradient].append(PointB)

        # 查找map
        max_notzero_num = 0
        max_zero_num = 0
        max_num = 0

        for Point in point_dict:
            max_notzero_num = 0
            max_zero_num = 0
            for gradient in point_dict[Point]:
                if gradient == (0,0):
                    if len(point_dict[Point][gradient]) > max_zero_num:
                        max_zero_num = len(point_dict[Point][gradient])

                else:
                    if len(point_dict[Point][gradient]) > max_notzero_num:
                        max_notzero_num = len(point_dict[Point][gradient])

                if max_zero_num + max_notzero_num + 1 > max_num:
                    max_num = max_zero_num + max_notzero_num + 1

        return max_num

    def gcd(self, a, b):

        if b:
            if a % b == 0:
                return b
            else:
                return self.gcd(b, a % b)
        elif a:
            return 0
        else:
            return -1

    def get_gradient_by_gcd(self, PointA, PointB):
        '''
        @usage: 用gcd表示斜率并返回
        :param PointA:
        :param PointB:
        :return:
        '''
        width = PointB.y - PointA.y  # 宽差
        height = PointB.x - PointA.x  # 高差

        GCD = self.gcd(abs(width), abs(height))

        if GCD > 0:
            return ((width/GCD), (height/GCD))
        elif GCD == 0:
            return (1, 0)
        else:
            return (0, 0)


if __name__ == '__main__':
    point1 = Point(1, 1)
    point2 = Point(1, 1)
    point3 = Point(2, 2)
    print(Solution().maxPoints([point1, point2, point3]))