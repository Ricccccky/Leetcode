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
        
        start = 0
        end = len(nums) - 1

        while (start + 1 < end):
            median = (end - start) // 2 + start
            if nums[median] == target:
                return median
            elif nums[median] < target:
                start = median
            else:
                end = median

        if nums[start] >= target:
            return start
        elif nums[end] >= target:
            return end
        else:
            return end + 1
# @lc code=end

