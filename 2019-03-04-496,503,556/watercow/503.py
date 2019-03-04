# 骚操作：直接把nums扩充两倍，不用考虑循环
class Solution(object):
    def nextGreaterElements(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        res = [-1]*len(nums)
        stack = []
        for i in list(range(len(nums))) * 2:
            while stack and (nums[stack[-1]] < nums[i]):
                res[stack.pop()] = nums[i]
            stack.append(i)
        return res