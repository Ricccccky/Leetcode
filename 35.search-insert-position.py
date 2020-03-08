#
# @lc app=leetcode id=35 lang=python3
#
# [35] Search Insert Position
#

# @lc code=start
class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        if (nums == None or len(nums) == 0):
            return 0
        
        for i in range(len(nums)):
            if nums[i] == target:
                return i
            elif nums[i] < target:
                continue
            else:
                return i
        return len(nums)
# @lc code=end

