# Definition for a point.
# class Point:
#     def __init__(self, a=0, b=0):
#         self.x = a
#         self.y = b


class Solution:
    def maxPoints(self, points: List[Point]) -> int:
        if len(points) <= 2:
            return len(points)
        result = 0
        for i, point1 in enumerate(points):
            cache = {}
            duplicate = 1
            for _, point2 in enumerate(points[i+1:]):
                if point1.x == point2.x and point1.y == point2.y:
                    duplicate += 1
                else:
                    a = point1.y - point2.y
                    b = point1.x - point2.x
                    k = self.gcd(a, b)
                    a /= k
                    b /= k
                    if (a, b) not in cache:
                        cache[(a, b)] = 1
                    else:
                        cache[(a, b)] += 1
            if result < duplicate:
                result = duplicate
            for val in cache:
                if cache[val] + duplicate > result:
                    result = cache[val] + duplicate
        return result

    def gcd(self, a, b):
        if b == 0:
            return a
        return self.gcd(b, a % b)
