#!/usr/bin/env python3
class Solution(object):
    def twoSum(self, nums, target):
        dic = {}
        for i, num in enumerate(nums):
            if target - num in dic:
                return (dic[target - num], i)
                break
            dic[num] = i
        return ()
