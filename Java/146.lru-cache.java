import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
class LRUCache {

    class LinkedNode {
        int key;
        int value;
        LinkedNode pre;
        LinkedNode next;
    }

    private LinkedNode head, tail;
    private int count;
    private int capacity;
    private Map<Integer, LinkedNode> map;

    private void addNode(LinkedNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(LinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public LRUCache(int capacity) {
        count = 0;
        this.capacity = capacity;
        map = new HashMap<>();
        head = new LinkedNode();
        tail = new LinkedNode();
        head.pre = null;
        tail.next = null;
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            LinkedNode node = map.get(key);
            removeNode(node);
            addNode(node);
            return node.value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            LinkedNode node = map.get(key);
            node.value = value;
            removeNode(node);
            addNode(node);
        } else {
            if (count < capacity) {
                LinkedNode node = new LinkedNode();
                node.value = value;
                node.key = key;
                addNode(node);
                map.put(key, node);
                count++;
            } else {
                LinkedNode node = tail.pre;
                map.remove(node.key);
                removeNode(node);

                node = new LinkedNode();
                node.value = value;
                node.key = key;
                addNode(node);
                map.put(key, node);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

