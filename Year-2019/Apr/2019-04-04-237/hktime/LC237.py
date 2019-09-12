# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-09-12 09:32:38
# @Last Modified by:   HK
# @Last Modified time: 2019-09-12 09:32:40
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def deleteNode(self, node):
        """
        :type node: ListNode
        :rtype: void Do not return anything, modify node in-place instead.
        """
        node.val = node.next.val
        node.next = node.next.next