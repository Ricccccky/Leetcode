import java.util.Arrays;
import java.util.Stack;

/*
 * @lc app=leetcode id=449 lang=java
 *
 * [449] Serialize and Deserialize BST
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        String result = "";
        Stack<TreeNode> temp = new Stack<>();
        while (root != null || !temp.isEmpty()) {
            if (root != null) {
                result += root.val + ","; 
                temp.push(root);
                root = root.left;
            } else {
                root = temp.pop().right;
            }
        }
        return result.substring(0, result.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String[] dataArray = data.split(",");
        return buildTree(dataArray, 0, dataArray.length - 1);
    }

    public TreeNode buildTree(String[] data, int start, int end) {
        if (start > end || end >= data.length || start < 0) {
            return null;
        }
        TreeNode result = new TreeNode(Integer.valueOf(data[start]));
        int p = start + 1;
        while (p <= end && Integer.valueOf(data[p]) < result.val) {
            p++;
        }
        result.left = buildTree(data, start + 1, p - 1);
        result.right = buildTree(data, p, end);
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
// @lc code=end

