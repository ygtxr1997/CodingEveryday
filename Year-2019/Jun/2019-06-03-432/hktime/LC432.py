# -*- coding: utf-8 -*-
# @Author: HK
# @Date:   2019-07-31 09:35:50
# @Last Modified by:   HK
# @Last Modified time: 2019-07-31 11:16:41
class AllOne:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.mykey = {}

    def inc(self, key: str) -> None:
        """
        Inserts a new key <Key> with value 1. Or increments an existing key by 1.
        """
        if key not in self.mykey:
            self.mykey[key] = 1
        else:
            self.mykey[key] += 1

    def dec(self, key: str) -> None:
        """
        Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
        """
        if key in self.mykey:
            if self.mykey[key] == 1:
                self.mykey.pop(key)
            else:
                self.mykey[key] -= 1
        

    def getMaxKey(self) -> str:
        """
        Returns one of the keys with maximal value.
        """
        maxkey = ''
        maxitem = 0
        for key in self.mykey:
            if self.mykey[key] > maxitem:
                maxitem = self.mykey[key]
                maxkey = key
        return maxkey
        

    def getMinKey(self) -> str:
        """
        Returns one of the keys with Minimal value.
        """
        minkey = ''
        minitem = float('inf')
        for key in self.mykey:
            if self.mykey[key] < minitem:
                minitem = self.mykey[key]
                minkey = key
        return minkey
        


# Your AllOne object will be instantiated and called as such:
# obj = AllOne()
# obj.inc(key)
# obj.dec(key)
# param_3 = obj.getMaxKey()
# param_4 = obj.getMinKey()