# medium难度主要在于看懂题目
# 解法一，用两个栈模拟过程，尽量保持两个栈深度一致


class Solution:
    def maxDepthAfterSplit(self, seq: str) -> List[int]:
        stackA, stackB = [], []
        res = []
        for s in seq:
            if s == '(':
                if len(stackA) <= len(stackB):
                    stackA.append(s)
                    res.append(0)
                else:
                    stackB.append(s)
                    res.append(1)
            else:
                if stackA and stackA[-1] == '(':
                    stackA.pop()
                    res.append(0)
                elif stackB and stackB[-1] == '(':
                    stackB.pop()
                    res.append(1)
        return res
# 解法二，用变量表示栈深度即可


class Solution:
    def maxDepthAfterSplit(self, seq: str) -> List[int]:
        a, b = 0, 0
        res = []
        for s in seq:
            if s == '(':
                if a <= b:
                    a += 1
                    res.append(0)
                else:
                    b += 1
                    res.append(1)
            else:
                if a > 0:
                    a -= 1
                    res.append(0)
                elif b > 0:
                    b -= 1
                    res.append(1)
        return res
# 解法三，用一个变量表示深度之和即可


class Solution:
    def maxDepthAfterSplit(self, seq: str) -> List[int]:
        a = 0
        res = []
        for s in seq:
            if s == '(':
                res.append(a % 2)
                a += 1
            else:
                a -= 1
                res.append(a % 2)
        return res
