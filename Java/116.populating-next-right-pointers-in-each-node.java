import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=116 lang=java
 *
 * [116] Populating Next Right Pointers in Each Node
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> temp = new LinkedList<>();
        Node head = root;
        int len;
        temp.offer(root);
        while (!temp.isEmpty()) {
            len = temp.size();
            Node pre = null;
            for (int i = 0; i < len; i++) {
                root = temp.poll();
                if (pre != null) {
                    pre.next = root;
                }
                pre = root;
                if (root.left != null) {
                    temp.offer(root.left);
                }
                if (root.right != null) {
                    temp.offer(root.right);
                }
            }
            pre.next = null;
        }
        return head;
    }
}
// @lc code=end

