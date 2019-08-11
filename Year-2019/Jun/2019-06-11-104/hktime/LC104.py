# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-08-11 10:13:17
# @Last Modified by:   HK
# @Last Modified time: 2019-08-11 10:13:25
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        # 递归
        # if root == None:
        #     return 0
        # if root.left == None and root.right == None :
        #     return 1
        # elif root.left != None and root.right == None:
        #     return 1 + self.maxDepth(root.left)
        # elif root.left == None and root.right != None:
        #     return 1 + self.maxDepth(root.right)
        # else:
        #     return 1 + max(self.maxDepth(root.left), self.maxDepth(root.right))
        # 迭代
        if root == None:
            return 0
        stack = []
        stack.append([1, root])
        depth = 1
        while stack != []:
            current_depth, root = stack.pop()
            if root != None:
                depth = max(current_depth, depth)
                stack.append([current_depth + 1, root.left])
                stack.append([current_depth + 1, root.right])
        return depth
