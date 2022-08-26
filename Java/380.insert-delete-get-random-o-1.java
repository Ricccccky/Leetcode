import java.util.*;

/*
 * @lc app=leetcode id=380 lang=java
 *
 * [380] Insert Delete GetRandom O(1)
 */

// @lc code=start
class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    Random rand;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, list.size());
            list.add(val);
            return true;
        } else {
            return false;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.get(val);
            int last = list.get(list.size() - 1);
            // Swap last and val
            map.put(last, index);
            map.remove(val);
            list.set(index, last);
            list.remove(list.size() - 1);
            return true;
        } else {
            return false;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int index = rand.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
// @lc code=end

