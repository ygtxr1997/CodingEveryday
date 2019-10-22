# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-10-22 14:39:12
# @Last Modified by:   HK
# @Last Modified time: 2019-10-22 14:39:21


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        retNum = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    self.infect(grid, i, j)
                    retNum += 1
        return retNum
        
    def infect(self, grid, i, j):
        if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[0]) or grid[i][j] != '1':
            return
        grid[i][j] = '2'
        self.infect(grid, i-1, j)
        self.infect(grid, i+1, j)
        self.infect(grid, i, j-1)
        self.infect(grid, i, j+1)