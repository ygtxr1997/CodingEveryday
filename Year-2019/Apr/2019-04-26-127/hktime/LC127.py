# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-10-21 15:24:34
# @Last Modified by:   HK
# @Last Modified time: 2019-10-21 15:24:42


class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList:
            return 0
        
        head = {beginWord}
        tail = {endWord}
        Set = set(wordList)
        chars = 'abcdefghijklmnopqrstuvwxyz'
        
        ret = 1
        while head:
            # 这步大幅优化时间
            # 每次都只遍历节点最少的中间队列
            if len(head) > len(tail):
                head, tail = tail, head
            
            q = set()
            ret += 1
            for cur in head:
                for i in range(len(beginWord)):
                    for ch in chars:
                        temp = cur[0:i] + ch + cur[i+1:]
                        if temp in tail:
                            return ret
                        
                        if temp in Set:
                            q.add(temp)
                            Set.remove(temp)
            head = q
        return 0
                        
        