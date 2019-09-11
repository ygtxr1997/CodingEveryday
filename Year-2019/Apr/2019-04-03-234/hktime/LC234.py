# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-09-11 11:10:11
# @Last Modified by:   HK
# @Last Modified time: 2019-09-11 14:07:13
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if head == None or head.next == None: return True
        # list存储，判断list是否可逆
        # p, stack = head, []
        # while p:
        #     stack.append(p.val)
        #     p = p.next
        # return stack == stack[::-1]
        # 快慢指针
        slow, fast = head, head
        rev = None
        # 找到中间节点
        while fast:
            slow = slow.next
            fast = fast.next.next if fast.next else fast.next
        # 将后半部分逆序
        while slow:
            rev, rev.next, slow = slow, rev, slow.next
        # 开始比较
        while head and rev:
            if head.val != rev.val:
                return False
            head = head.next
            rev = rev.next
        return True
