# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-06-25 20:53:08
# @Last Modified by:   HK
# @Last Modified time: 2019-06-25 20:53:42


class Solution:
    def sampleStats(self, count: List[int]) -> List[float]:
        n = sum(count)
        left_cnt, right_cnt = 0, 0
        if n % 2 == 0:
            left_cnt, right_cnt = n // 2, n // 2 + 1
        else:
            left_cnt, right_cnt = n // 2 + 1, n // 2 + 1
        s, c = 0, 0
        max_cnt, max_cnt_index = 0, 0
        max_cnt_index = 0
        max_num, medium, min_num = 0, 0, -1
        left_flg, right_flg = False, False
        for i in range(256):
            c += count[i]
            if c >= left_cnt and not left_flg:
                medium += i
                left_flg = True
            if c >= right_cnt and not right_flg:
                medium += i
                right_flg = True
            s += count[i] * i
            if count[i] > max_cnt:
                max_cnt = count[i]
                max_cnt_index = i
            if count[i] > 0:
                max_num = i
                if min_num == -1:
                    min_num = i
        return [float(min_num), float(max_num), float(s / n), float(medium / 2), float(max_cnt_index)]
