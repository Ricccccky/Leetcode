import java.util.*;

/*
 * @lc app=leetcode id=1506 lang=java
 *
 * [1506] Find Root of N-Ary Tree
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public Node findRoot(List<Node> tree) {
        int sum = 0;
        Node root = null;
        for (Node node : tree) {
            sum += node.val;
            for (Node child : node.children) {
                sum -= child.val;
            }
        }
        for (Node node : tree) {
            if (node.val == sum) {
                root = node;
                break;
            }
        }

        return root;
    }
}
// @lc code=end

