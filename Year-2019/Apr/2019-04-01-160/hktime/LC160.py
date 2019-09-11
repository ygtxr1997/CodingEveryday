# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-09-09 13:52:05
# @Last Modified by:   HK
# @Last Modified time: 2019-09-11 14:07:25

#
# Be water, my friend.
#
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        # 关键在于长短链表长度差
        if (headA == None or headB == None):
            return None
        pA, pB = headA, headB
        while (pA != pB):
            pA = pA.next if pA else headB
            pB = pB.next if pB else headA
        return pA