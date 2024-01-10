/*
 * @lc app=leetcode id=536 lang=java
 *
 * [536] Construct Binary Tree from String
 */

// @lc code=start

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode str2tree(String s) {
        Deque<TreeNode> stack = new LinkedList<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == ')') {
                stack.pop();
            } else if (c == '-' || Character.isDigit(c)) {
                int sign = 1, num = 0;
                if (c == '-') {
                    sign = -1;
                    i++;
                }
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                i--;
                num *= sign;
                TreeNode node = new TreeNode(num);
                if (!stack.isEmpty()) {
                    TreeNode parent = stack.peek();
                    if (parent.left == null) {
                        parent.left = node;
                    } else if (parent.right == null) {
                        parent.right = node;
                    }
                }
                stack.push(node);
            }
        }

        return stack.isEmpty() ? null : stack.pop();
    }
}
// @lc code=end

