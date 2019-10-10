# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-10-10 10:26:35
# @Last Modified by:   HK
# @Last Modified time: 2019-10-10 10:26:58


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        return self.traTree(root, 0)
    
    def traTree(self, root, sum):
        if not root:
            return 0
        elif not root.left and not root.right:
            return sum * 10 + root.val
        return self.traTree(root.left, 10 * sum + root.val) + self.traTree(root.right, 10 * sum + root.val)
