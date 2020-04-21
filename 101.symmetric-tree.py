#
# @lc app=leetcode id=101 lang=python3
#
# [101] Symmetric Tree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if root == None:
            return True
        # Recursive method
        # else:
        #     return self.subCompare(root.left, root.right)


        # Iterative method
        stack = []
        stack.append(root.left)
        stack.append(root.right)

        while stack:
            right = stack.pop()
            left = stack.pop()

            if left == None and right == None:
                continue
            elif (left == None or right == None) or (left.val != right.val):
                return False
            
            stack.append(left.left)
            stack.append(right.right)
            stack.append(left.right)
            stack.append(right.left)
        
        return True
    
    def subCompare(self, left, right):
        if left == None and right == None:
            return True
        elif left == None or right == None:
            return False
        elif left.val != right.val:
            return False
        else:
            return self.subCompare(left.left, right.right) and self.subCompare(left.right, right.left)

# @lc code=end

