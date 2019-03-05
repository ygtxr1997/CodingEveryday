#!/usr/bin/env python  
#-*- coding:utf-8 _*-  
""" 
@author:watercow 
@license: Apache Licence 
@file: test.py 
@time: 2019/03/05
@site:  
@software: PyCharm 

# code is far away from bugs with the god animal protecting
    I love animals. They taste delicious.
              ┏┓      ┏┓
            ┏┛┻━━━┛┻┓
            ┃      ☃      ┃
            ┃  ┳┛  ┗┳  ┃
            ┃      ┻      ┃
            ┗━┓      ┏━┛
                ┃      ┗━━━┓
                ┃  神兽保佑    ┣┓
                ┃　永无BUG！   ┏┛
                ┗┓┓┏━┳┓┏┛
                  ┃┫┫  ┃┫┫
                  ┗┻┛  ┗┻┛ 
"""
# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def __init__(self):
        self.count = 0
        self.flag = False
        self.LevelLastnum = 0 # 最后一层的节点数

    def countNodes(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0

        r = root
        level_count = 0 # 记录层数
        while r:
            level_count += 1
            r = r.left

        num1 = 2**(level_count-1) - 1 # 到level_count-1层的节点数

        self.preorder(1, level_count, root) # root层记为1而不是0

        return self.count/2 + num1

    def preorder(self, cur_level, level_count, node):
        if not self.flag:
            if not node and cur_level == level_count:
                self.flag = True
                return

            if cur_level == level_count + 1:
                self.count += 1
                return

            self.preorder(cur_level + 1, level_count, node.left)
            self.preorder(cur_level + 1, level_count, node.right)