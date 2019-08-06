# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-08-05 14:34:20
# @Last Modified by:   HK
# @Last Modified time: 2019-08-06 15:02:02


class Solution:
    def validUtf8(self, data: List[int]) -> bool:
        # 直接按照规则比较
        # one_bit = 0
        # for num in data:
        #     bin_num = format(num, '#010b')[-8:]
        #     if one_bit == 0:
        #         for bit in bin_num:
        #             if bit == '0':
        #                 break
        #             one_bit += 1
        #         if one_bit == 1 or one_bit > 4:
        #             return False
        #         if one_bit == 0:
        #             continue
        #     else:
        #         if not (bin_num[0] == '1' and bin_num[1] == '0'):
        #             return False
        #     one_bit -= 1
        # return one_bit == 0

        # 位运算
        mask1 = 1 << 7
        mask2 = 1 << 6
        one_bit = 0
        for num in data:
            if one_bit == 0:
                mask = 1 << 7
                while mask & num:
                    mask = mask >> 1
                    one_bit += 1
                if one_bit == 1 or one_bit > 4:
                    return False
                if one_bit == 0:
                    continue
            else:
                if not(mask1 & num and not(mask2 & num)):
                    return False
            one_bit -= 1
        return one_bit == 0
