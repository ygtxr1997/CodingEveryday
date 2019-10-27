# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-10-27 16:59:46
# @Last Modified by:   HK
# @Last Modified time: 2019-10-27 16:59:50


class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        if len(prerequisites) == 0:
            return [i for i in range(numCourses)]
        
        inList = [0 for _ in range(numCourses)]
        adj = [set() for _ in range(numCourses)]
        zeros = []
        ret = []
        
        # 计算入度，邻接表
        for second, first in prerequisites:
            inList[second] += 1
            adj[first].add(second)
            
        # 入度为0的节点
        for i in range(len(inList)):
            if inList[i] == 0:
                zeros.append(i)
        
        # 开始剔除节点
        while zeros:
            zero = zeros.pop(0)
            ret.append(zero)
            for node in adj[zero]:
                inList[node] -= 1
                if inList[node] == 0:
                    zeros.append(node)
        return ret if len(ret) == numCourses else []
            
            
        