# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-10-08 14:29:39
# @Last Modified by:   HK
# @Last Modified time: 2019-10-08 14:29:48
# 二叉搜索树方法
class TreeNode(object):
    def __init__(self, val):
        self.left = None
        self.right = None
        self.val = val
        self.count = 0

class Solution:
    def countSmaller(self, nums: List[int]) -> List[int]:
        # 暴力法超时
        # counts = []
        # for ind, num in enumerate(nums):
        #     count = 0
        #     for i in nums[ind+1:]:
        #         if num > i:
        #             count += 1
        #     counts.append(count)
        # return counts
        length = len(nums)
        root = None
        res = [0 for _ in range(length)]
        for i in reversed(range(length)):
            root = self.insertNode(root, nums[i], res, i)
        return res
    
    def insertNode(self, root, val, res, res_index):
        if root == None:
            root = TreeNode(val)
        elif val <= root.val:
            root.count += 1
            root.left = self.insertNode(root.left, val ,res, res_index)
        elif val > root.val:
            res[res_index] += root.count + 1
            root.right = self.insertNode(root.right, val, res, res_index)
        return root