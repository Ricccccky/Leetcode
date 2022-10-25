import java.util.*;

/*
 * @lc app=leetcode id=1522 lang=java
 *
 * [1522] Diameter of N-Ary Tree
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
    public int diameter(Node root) {
        Map<Node, Integer> map = new HashMap<>();
        int res = 0;
        dfs(root, map);
        for (Map.Entry<Node, Integer> entry : map.entrySet()) {
            res = Math.max(res, entry.getValue());
        }

        return res;
    }

    private int dfs(Node root, Map<Node, Integer> map) {
        int first = 0;
        int second = 0;
        for (Node node : root.children) {
            int tmp = dfs(node, map);
            if (first < tmp) {
                second = first;
                first = tmp;
            } else if (second < tmp) {
                second = tmp;
            }
        }
        map.put(root, first + second);

        return first + 1;
    }
}
// @lc code=end

