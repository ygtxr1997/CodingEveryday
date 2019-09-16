# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-09-16 10:05:42
# @Last Modified by:   HK
# @Last Modified time: 2019-09-16 10:05:49
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root == None or root == p or root == q:
            return root
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        if left == None and right == None:
            return None
        elif left !=None and right != None:
            return root
        else:
            return right if left == None else left 
        