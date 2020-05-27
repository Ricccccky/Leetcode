#
# @lc app=leetcode id=26 lang=python3
#
# [26] Remove Duplicates from Sorted Array
#
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        NumsLen = len(nums)
        if NumsLen == 0:
            return 0
        j = 0
        for i in range(NumsLen):
            if nums[i] != nums[j]:
                j += 1
                nums[j] = nums[i]
        return j + 1

