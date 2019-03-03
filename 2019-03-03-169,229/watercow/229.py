#摩尔投票法 Moore Voting
# 题目中给了一条很重要的提示，让我们先考虑可能会有多少个众数，
# 任意一个数组出现次数大于n/3的众数最多有两个那
# 第一遍历找出两个候选众数
# 第二遍遍历重新投票验证这两个候选众数是否为众数即可

class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        res = []
        num1 = 0
        num2 = 0
        count_num1 = 0
        count_num2 = 0

        for num in nums:
            if num == num1:
                count_num1 += 1

            elif num == num2:
                count_num2 += 1

            elif count_num1 == 0:
                num1 = num
                count_num1 = 1

            elif count_num2 == 0:
                num2 = num
                count_num2 = 1
            else:
                count_num1 -= 1
                count_num2 -= 1

        count1 = 0
        count2 = 0
        for num in nums:
            if num == num1:
                count1 += 1
            elif num == num2:
                count2 += 1

        if count1 > (len(nums) / 3):
            res.append(count_num1)
        if count2 > (len(nums) / 3):
            res.append(count_num2)

        return res

if __name__ == '__main__':
    nums = [1,4,3,3]
    print(Solution().majorityElement(nums))
