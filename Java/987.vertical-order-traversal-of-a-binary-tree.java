import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
 * @lc app=leetcode id=987 lang=java
 *
 * [987] Vertical Order Traversal of a Binary Tree
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
    class Coordinate implements Comparable<Coordinate> {
        int row;
        int col;
        int val;

        public Coordinate(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }

        @Override
        public int compareTo(Coordinate o) {
            if (this.col != o.col) {
                return Integer.compare(this.col, o.col);
            } else if (this.row != o.row) {
                return Integer.compare(this.row, o.row);
            } else {
                return Integer.compare(this.val, o.val);
            }
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Coordinate> list = new ArrayList<>();
        dfs(list, 0, 0, root);
        Collections.sort(list);
        int prev = Integer.MIN_VALUE;
        for (Coordinate c : list) {
            if (c.col != prev) {
                res.add(new ArrayList<>());
                prev = c.col;
            }
            res.get(res.size() - 1).add(c.val);
        }
        
        return res;
    }
    
    private void dfs(List<Coordinate> list, int row, int col, TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(new Coordinate(row, col, root.val));
        dfs(list, row + 1, col - 1, root.left);
        dfs(list, row + 1, col + 1, root.right);
    }
}
// @lc code=end

