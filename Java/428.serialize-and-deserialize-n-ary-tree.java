import java.util.*;

/*
 * @lc app=leetcode id=428 lang=java
 *
 * [428] Serialize and Deserialize N-ary Tree
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Deque<Node> queue = new LinkedList<>();
        sb.append(root.val);
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            sb.append("#");
            sb.append(root.children.size());
            for (Node child : root.children) {
                sb.append("#");
                queue.offer(child);
                sb.append(child.val);
            }
        }

        return sb.toString();
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        Deque<Node> queue = new LinkedList<>();
        String[] arr = data.split("#");
        Node root = new Node(Integer.parseInt(arr[0]), new ArrayList<>());
        queue.offer(root);
        int i = 1;
        while (i < arr.length) {
            int size = Integer.parseInt(arr[i++]);
            Node ptr = queue.poll();
            while (size-- > 0) {
                Node child = new Node(Integer.parseInt(arr[i++]), new ArrayList<>());
                ptr.children.add(child);
                queue.offer(child);
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
// @lc code=end

