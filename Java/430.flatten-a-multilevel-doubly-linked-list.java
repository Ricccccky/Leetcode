import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=430 lang=java
 *
 * [430] Flatten a Multilevel Doubly Linked List
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        Deque<Node> stack = new LinkedList<>();
        Node dummy = new Node(0, null, head, null);
        Node ptr, prev = dummy;
        stack.push(head);
        while (!stack.isEmpty()) {
            ptr = stack.pop();
            ptr.prev = prev;
            prev.next = ptr;
            if (ptr.next != null) {
                stack.push(ptr.next);
            }
            if (ptr.child != null) {
                stack.push(ptr.child);
                ptr.child = null;
            }
            prev = prev.next;
        }
        dummy.next.prev = null;

        return dummy.next;
    }
}
// @lc code=end

