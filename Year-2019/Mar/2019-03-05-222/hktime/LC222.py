#!/usr/bin/env python  
#-*- coding:utf-8 _*-  
""" 
@author:hktime
@time: 2019/03/08

#
# Be water, my friend.
#
"""

# 递归
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def countNodes(self, root: TreeNode) -> int:
        if(root == None):
            return 0
        return 1 + self.countNodes(root.left)+ self.countNodes(root.right)
