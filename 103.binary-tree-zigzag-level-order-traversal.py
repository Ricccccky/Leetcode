#
# @lc app=leetcode id=103 lang=python3
#
# [103] Binary Tree Zigzag Level Order Traversal
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        if root == None:
            return None
        result = []
        stack = [root]
        numLevel = 1

        while stack:
            level = []
            stack_len = len(stack)
            for i in range(stack_len):
                node = stack.pop(0)
                level.append(node.val)
                if node.left:
                    stack.append(node.left)
                if node.right:
                    stack.append(node.right)

            if numLevel % 2 == 0:
                level = reversed(level)
            numLevel += 1
            result.append(level)
        
        return result
# @lc code=end

