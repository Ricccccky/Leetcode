import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import org.w3c.dom.Node;

/*
 * @lc app=leetcode id=133 lang=java
 *
 * [133] Clone Graph
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node root = new Node(node.val);
        HashMap<Integer, Node> temp = new HashMap<>();
        temp.put(root.val, root);
        Queue<Node> queue = new LinkedList<>();
        Node top = null;
        queue.offer(node);
        while (!queue.isEmpty()) {
            top = queue.poll();
            for (Node k : top.neighbors) {
                if (!temp.containsKey(k.val)) {
                    Node newNode = new Node(k.val);
                    temp.put(k.val, newNode);
                    queue.offer(k);
                }
                temp.get(top.val).neighbors.add(temp.get(k.val));
            }
        }
        return root;
    }
}
// @lc code=end

