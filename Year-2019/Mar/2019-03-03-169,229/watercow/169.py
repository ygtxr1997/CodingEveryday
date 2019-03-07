# 使用count记录次数
# 遇到相同的数+1，遇到不同的-1
# 使用cur_num记录当前数，count为0时更换cur_num
# 最后的cur_num就是最多的num

class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return None

        count = 1
        cur_num = nums[0]

        for i in range(1, len(nums)):
            if nums[i] == cur_num:
                count += 1
            if nums[i] != cur_num:
                count -= 1
            if count == 0:
                cur_num = nums[i]
                count = 1

        return cur_num