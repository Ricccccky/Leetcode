/*
 * @lc app=leetcode id=708 lang=java
 *
 * [708] Insert into a Sorted Circular Linked List
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if (head == null) {
            node.next = node;
            return node;
        }
        Node prev = head, cur = head.next;
        while (cur != head) {
            if (insertVal >= prev.val && insertVal <= cur.val) {
                break;
            }
            if (prev.val > cur.val && (insertVal >= prev.val || insertVal <= cur.val)) {
                break;
            }
            prev = cur;
            cur = cur.next;
        }
        prev.next = node;
        node.next = cur;

        return head;
    }
}
// @lc code=end

