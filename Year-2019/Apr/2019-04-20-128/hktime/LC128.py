# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-10-13 11:34:34
# @Last Modified by:   HK
# @Last Modified time: 2019-10-13 11:34:41


Dic = {}
        for num in nums:
            if num in Dic:
                continue
            elif num - 1 not in Dic and num + 1 not in Dic:
                Dic[num] = 1
            elif num + 1 not in Dic:
                Dic[num] = Dic[num - 1] + 1
                Dic[num - Dic[num - 1]] = Dic[num]
            elif num - 1 not in Dic:
                Dic[num] = Dic[num + 1] + 1
                Dic[num + Dic[num + 1]] = Dic[num]                
            else:
                Dic[num] = Dic[num - 1] + Dic[num + 1] + 1
                Dic[num - Dic[num - 1]] = Dic[num]
                Dic[num + Dic[num + 1]] = Dic[num]
        ret = 0 
        for key in Dic:
            ret = max(ret, Dic[key])
        return ret
        # 时间复杂度O(nlogn)
        # if nums == []:
        #     return 0
        # nums = list(set(nums))
        # nums.sort()
        # ret = 1
        # i = 0
        # while i < len(nums) - 1:
        #     count = 1
        #     for j in range(i + 1, len(nums)):
        #         if nums[j] == nums[i] + 1:
        #             count += 1
        #             i += 1
        #         else:
        #             i = j
        #             break
        #     if count > ret:
        #         ret = count
        # return ret