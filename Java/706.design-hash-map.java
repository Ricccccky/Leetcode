import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=706 lang=java
 *
 * [706] Design HashMap
 */

// @lc code=start
class MyHashMap {
    class KV_pair<K, V> {
        private K key;
        private V val;

        public KV_pair(K key, V val) {
            this.key = key;
            this.val = val;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.val;
        }

        public void setValue(V value) {
            this.val = value;
        }
    }

    class Chain {
        private List<KV_pair<Integer, Integer>> chain;

        public Chain() {
            this.chain = new ArrayList<>();
        }

        public Integer get(Integer key) {
            for (KV_pair<Integer, Integer> pair : this.chain) {
                if (pair.getKey().equals(key)) {
                    return pair.getValue();
                }
            }
            return -1;
        }

        public void update(Integer key, Integer value) {
            boolean found = false;
            for (KV_pair<Integer, Integer> pair : this.chain) {
                if (pair.getKey().equals(key)) {
                    pair.setValue(value);
                    found = true;
                }
            }

            if (!found) {
                this.chain.add(new KV_pair<Integer, Integer>(key, value));
            }
        }

        public void remove(Integer key) {
            for (KV_pair<Integer, Integer> pair : this.chain) {
                if (pair.getKey().equals(key)) {
                    this.chain.remove(pair);
                    break;
                }
            }
        }
    }

    int hash_base;
    List<Chain> table;
    /** Initialize your data structure here. */
    public MyHashMap() {
        hash_base = 4096;
        table = new ArrayList<Chain>();
        for (int i = 0; i < hash_base; i++) {
            table.add(new Chain());
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = key % this.hash_base;
        table.get(hash).update(key, value);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = key % this.hash_base;
        return table.get(hash).get(key);
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = key % this.hash_base;
        table.get(hash).remove(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
// @lc code=end

