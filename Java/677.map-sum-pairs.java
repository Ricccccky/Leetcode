import java.util.*;

/*
 * @lc app=leetcode id=677 lang=java
 *
 * [677] Map Sum Pairs
 */

// @lc code=start
class MapSum {
    private MapSum[] next;
    private int val;

    public MapSum() {
        next = new MapSum[26];
        val = 0;
    }
    
    public void insert(String key, int val) {
        MapSum root = this;
        for (char c : key.toCharArray()) {
            if (root.next[c - 'a'] == null) {
                root.next[c - 'a'] = new MapSum();
            }
            root = root.next[c - 'a'];
        }
        root.val = val;
    }
    
    public int sum(String prefix) {
        MapSum root = this;
        Queue<MapSum> queue = new LinkedList<>();
        int sum = 0;
        for (char c : prefix.toCharArray()) {
            if (root.next[c - 'a'] == null) {
                return sum;
            }
            root = root.next[c - 'a'];
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len-- > 0) {
                MapSum top = queue.poll();
                sum += top.val;
                for (int i = 0; i < 26; i++) {
                    if (top.next[i] != null) {
                        queue.offer(top.next[i]);
                    }
                }
            }
        }

        return sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
// @lc code=end

