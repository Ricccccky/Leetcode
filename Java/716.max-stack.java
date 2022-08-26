import java.util.*;

/*
 * @lc app=leetcode id=716 lang=java
 *
 * [716] Max Stack
 */

// @lc code=start
class MaxStack {
    // TreeMap + DeLinkedList: O(logN); Two stacks: O(N)
    
    class Node {
        int val;
        Node prev, next;

        public Node(int val) {
            this.val = val;
        }
    }

    class Delinkedlist {
        Node head, tail;

        public Delinkedlist() {
            head = new Node(-1);
            tail = new Node(-1);
            head.next = tail;
            tail.prev = head;
        }

        public Node addNode(int x) {
            Node node = new Node(x);
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;

            return node;
        }

        public void deleteNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public int peek() {
            return head.next.val;
        }

        public int pop() {
            int val = head.next.val;
            deleteNode(head.next);

            return val;
        }
    }

    TreeMap<Integer, List<Node>> map;
    Delinkedlist stack;

    public MaxStack() {
        map = new TreeMap<>((k1, k2) -> k2 - k1);
        stack = new Delinkedlist();
    }
    
    public void push(int x) {
        Node node = stack.addNode(x);
        if (!map.containsKey(x)) {
            map.put(x, new ArrayList<>());
        }
        map.get(x).add(node);
    }
    
    public int pop() {
        int val = stack.pop();
        map.get(val).remove(map.get(val).size() - 1);
        if (map.get(val).size() == 0) {
            map.remove(val);
        }

        return val;
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return map.firstKey();
    }
    
    public int popMax() {
        Map.Entry<Integer, List<Node>> entry = map.firstEntry();
        if (entry.getValue().size() == 1) {
            map.remove(entry.getKey());
        }
        stack.deleteNode(entry.getValue().get(entry.getValue().size() - 1));
        entry.getValue().remove(entry.getValue().size() - 1);

        return entry.getKey();
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
// @lc code=end

