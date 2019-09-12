# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-09-12 14:34:53
# @Last Modified by:   HK
# @Last Modified time: 2019-09-12 14:34:56
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def oddEvenList(self, head: ListNode) -> ListNode:
        if head == None or head.next == None or head.next.next == None:
            return head
        # 奇数链
        odd = head
        # 偶数链
        even = head.next
        # 偶数链头节点
        q = head.next
        while odd.next != None and even.next != None:
            odd.next = even.next
            odd = odd.next
            even.next = odd.next
            even = even.next
        odd.next = q
        
        return head