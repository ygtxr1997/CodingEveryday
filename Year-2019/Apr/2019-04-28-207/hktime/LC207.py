# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-10-22 15:38:44
# @Last Modified by:   HK
# @Last Modified time: 2019-10-22 15:38:46


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if len(prerequisites) == 0:
            return True
        
        # 建立入度表和邻接表
        inList = [0 for _ in range(numCourses)] 
        adj = [set() for _ in range(numCourses)]   
        for second, first in prerequisites:
            inList[second] += 1
            adj[first].add(second)
        
        # 选择一个入度为0的顶点并输出之
        # 从网中删除此顶点及所有出边。
        queue = []
        for i in range(numCourses):
            if inList[i] == 0:
                queue.append(i)
        count = 0
        while queue:
            que = queue.pop(0)
            count += 1
            
            for successor in adj[que]:
                inList[successor] -= 1
                if inList[successor] == 0 :
                    queue.append(successor)
        return count == numCourses
            
            
        
        
            