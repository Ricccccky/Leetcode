import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
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
        StringBuilder result = new StringBuilder();
        if (root == null) {
            return "";
        }
        Queue<TreeNode> temp = new LinkedList<>();
        temp.offer(root);
        int len;
        while (!temp.isEmpty()) {
            len = temp.size();
            for (int i = 0; i < len; i++) {
                root = temp.poll();
                if (root != null) {
                    result.append(root.val).append(",");
                    temp.offer(root.left);
                    temp.offer(root.right);
                } else {
                    result.append("null,");
                }
            }
        }
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") {
            return null;
        }
        String[] dataArray = data.split(",");
        int end;
        for (end = dataArray.length - 1; end >= 0; end--) {
            if (!dataArray[end].equals("null")) {
                break;
            }
        }
        dataArray = Arrays.copyOfRange(dataArray, 0, end + 1);

        TreeNode root = new TreeNode(Integer.valueOf(dataArray[0]));
        TreeNode head = root;
        TreeNode p;
        int count = 1;
        Queue<TreeNode> temp = new LinkedList<>();
        temp.offer(head);
        while (!temp.isEmpty()) {
            p = temp.poll();
            if (count > dataArray.length - 1) {
                break;
            }
            if (!dataArray[count].equals("null")) {
                head = new TreeNode(Integer.valueOf(dataArray[count]));
                temp.offer(head);
                p.left = head;
            }
            count++;
            if (count > dataArray.length - 1) {
                break;
            }
            if (!dataArray[count].equals("null")) {
                head = new TreeNode(Integer.valueOf(dataArray[count]));
                temp.offer(head);
                p.right = head;
            }
            count++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
// @lc code=end

