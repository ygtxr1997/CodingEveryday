# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-10-10 10:26:35
# @Last Modified by:   HK
# @Last Modified time: 2019-10-11 10:55:25


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    ret = -sys.maxsize - 1
    def maxPathSum(self, root: TreeNode) -> int:
        self.getMax(root)
        return self.ret
        
    def getMax(self, root):
        if not root:
            return 0
        left = max(0, self.getMax(root.left))
        right = max(0, self.getMax(root.right))
        self.ret = max(self.ret, root.val + left + right)
        return max(left, right) + root.val