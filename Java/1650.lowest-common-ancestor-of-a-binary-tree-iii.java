/*
 * @lc app=leetcode id=1650 lang=java
 *
 * [1650] Lowest Common Ancestor of a Binary Tree III
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        int depthP = getDepth(p);
        int depthQ = getDepth(q);
        while (depthP > depthQ) {
            p = p.parent;
            depthP--;
        }
        while (depthP < depthQ) {
            q = q.parent;
            depthQ--;
        }
        while (p != q) {
            p = p.parent;
            q = q.parent;
        }

        return p;
    }

    private int getDepth(Node root) {
        int depth = 0;
        while (root != null) {
            root = root.parent;
            depth++;
        }

        return depth;
    }
}
// @lc code=end

