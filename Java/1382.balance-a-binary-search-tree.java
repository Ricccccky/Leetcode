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
    public TreeNode balanceBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        List<Integer> inorderList = inorder(root);
        return buildBST(inorderList, 0, inorderList.size() - 1);
    }
    
    public List<Integer> inorder(TreeNode root) {
        Stack<TreeNode> temp = new Stack<>();
        List<Integer> result = new ArrayList<>();
        while (root != null || !temp.isEmpty()) {
            if (root != null) {
                temp.push(root);
                root = root.left;
            } else {
                root = temp.pop();
                result.add(root.val);
                root = root.right;
            }
        }
        return result;
    }
    
    public TreeNode buildBST(List<Integer> sortedList, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(sortedList.get(mid));
        root.left = buildBST(sortedList, start, mid - 1);
        root.right = buildBST(sortedList, mid + 1, end);
        return root;
    }
}