/*
 * @lc app=leetcode id=426 lang=java
 *
 * [426] Convert Binary Search Tree to Sorted Doubly Linked List
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    Node prev = null;
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Node dummy = new Node(0, null, null);
        prev = dummy;
        dfs(root);
        prev.right = dummy.right;
        dummy.right.left = prev;
        
        return dummy.right;
    }

    private void dfs(Node root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        prev.right = root;
        root.left = prev;
        prev = root;
        dfs(root.right);
    }
}
// @lc code=end

