import java.util.*;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=653 lang=java
 *
 * [653] Two Sum IV - Input is a BST
 */

// @lc code=start
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
    public boolean findTarget(TreeNode root, int k) {
        // Traverse, less space
        Deque<TreeNode> stack = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                if (set.contains(k - root.val)) {
                    return true;
                }
                set.add(root.val);
                stack.addLast(root);
                root = root.left;
            } else {
                root = stack.removeLast();
                root = root.right;
            }
        }

        return false;

        // Build sorted array + Two pointer
        // List<Integer> list = buildArray(root);
        // int p1 = 0;
        // int p2 = list.size() - 1;
        // while (p1 < p2) {
        //     if (list.get(p1) + list.get(p2) == k) {
        //         return true;
        //     } else if (list.get(p1) + list.get(p2) > k) {
        //         p2--;
        //     } else {
        //         p1++;
        //     }
        // }

        // return false;
    }

    private List<Integer> buildArray(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.addLast(root);
                root = root.left;
            } else {
                root = stack.removeLast();
                list.add(root.val);
                root = root.right;
            }
        }

        return list;
    }
}
// @lc code=end

