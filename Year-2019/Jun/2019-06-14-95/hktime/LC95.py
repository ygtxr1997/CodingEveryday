# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-06-17 18:41:55
# @Last Modified by:   HK
# @Last Modified time: 2019-06-17 18:42:52
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def generateTrees(self, n: int) -> List[TreeNode]:
        return self.helper(range(1, n + 1))

    def helper(self, tree):
        ans = []
        for i, val in enumerate(tree):
            left, right = tree[:i], tree[i + 1:]
            for lTree in self.helper(left) or [None]:
                for rTree in self.helper(right) or [None]:
                    root = TreeNode(val)
                    root.left, root.right = lTree, rTree
                    ans.append(root)
        return ans
