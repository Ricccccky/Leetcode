import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

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
        public int x;
        public int y;
        public int val;
        
        public Coordinate(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Coordinate o) {
            if (this.x != o.x) {
                return Integer.compare(this.x, o.x);
            }
            if (this.y != o.y) {
                return Integer.compare(this.y, o.y);
            }
            return Integer.compare(this.val, o.val);
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Coordinate> coordinates = new ArrayList<>();
        dfs(root, coordinates, 0, 0);
        Collections.sort(coordinates);
        int cur = coordinates.get(0).x;
        result.add(new ArrayList<>());
        for (Coordinate loc : coordinates) {
            if (loc.x == cur) {
                result.get(result.size() - 1).add(loc.val);
            } else {
                result.add(new ArrayList<>());
                result.get(result.size() - 1).add(loc.val);
                cur = loc.x;
            }
        }
        return result;
    }

    private void dfs(TreeNode root, List<Coordinate> coordinates, int x, int y) {
        if (root == null) {
            return;
        }
        coordinates.add(new Coordinate(x, y, root.val));
        dfs(root.left, coordinates, x - 1, y + 1);
        dfs(root.right, coordinates, x + 1, y + 1);
    }
}
// @lc code=end

