import java.util.*;

import org.w3c.dom.Node;

/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node dummy = new Node(-1);
        Node ptr = dummy;
        Node origin = head;
        Map<Node, Node> map = new HashMap<>();
        while (origin != null) {
            Node cur = new Node(origin.val);
            ptr.next = cur;
            ptr = cur;
            map.put(origin, cur);
            origin = origin.next;
        }
        origin = head;
        ptr = dummy.next;
        while (origin != null) {
            Node rand = origin.random;
            ptr.random = map.get(rand);
            ptr = ptr.next;
            origin = origin.next;
        }

        return dummy.next;
    }
}
// @lc code=end

