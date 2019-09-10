# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-09-10 09:57:49
# @Last Modified by:   HK
# @Last Modified time: 2019-09-10 09:58:25
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
    	# 迭代方法
        p, rev = head, None
        while p:
        	# 多元赋值
            rev, rev.next, p = p, rev, p.next
        return rev
        