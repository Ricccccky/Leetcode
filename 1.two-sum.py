#
# @lc app=leetcode id=1 lang=python3
#
# [1] Two Sum
#

# @lc code=start
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        x = {}
        for i, n in enumerate(nums):
            if target - n in x:
                return x[target - n], i
            x[n] = i
# @lc code=end

