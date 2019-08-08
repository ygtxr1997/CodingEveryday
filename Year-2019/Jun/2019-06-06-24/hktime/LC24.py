# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-08-08 14:37:23
# @Last Modified by:   HK
# @Last Modified time: 2019-08-08 14:37:39
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        # 递归大法好
        if head == None or head.next == None:
            return head
        p = head.next
        head.next = self.swapPairs(p.next)
        p.next = head
        return p
