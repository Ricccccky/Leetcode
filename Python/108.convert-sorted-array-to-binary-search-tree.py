#
# @lc app=leetcode id=108 lang=python3
#
# [108] Convert Sorted Array to Binary Search Tree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> TreeNode:
        if len(nums) == 0:
            return None
        medi = len(nums) // 2

        root = TreeNode(nums[medi])
        root.left = self.sortedArrayToBST(nums[:medi])
        root.right = self.sortedArrayToBST(nums[medi + 1:])

        return root
# @lc code=end

