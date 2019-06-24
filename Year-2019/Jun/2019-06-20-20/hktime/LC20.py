# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-06-21 10:51:03
# @Last Modified by:   HK
# @Last Modified time: 2019-06-21 11:28:19


class Solution:
    def isValid(self, s: str) -> bool:
        charList = list(s)
        stack = []
        for c in charList:
            if c == '(' or c == '{' or c == '[':
                stack.append(c)
            elif c == ')':
                if stack == [] or stack.pop() != '(':
                    return False
            elif c == '}':
                if stack == [] or stack.pop() != '{':
                    return False
            else:
                if stack == [] or stack.pop() != '[':
                    return False
        return not stack
