# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-09-17 14:54:22
# @Last Modified by:   HK
# @Last Modified time: 2019-09-17 14:54:30


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        # BST中序遍历为排序数组
        self.res, self.count = None, k
        def inorder(root):
            if not (root and self.count): return
            inorder(root.left)
            self.count -= 1
            if not self.count: self.res = root.val
            inorder(root.right)
        inorder(root)
        return self.res
