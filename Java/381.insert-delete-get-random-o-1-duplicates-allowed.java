import java.util.*;

/*
 * @lc app=leetcode id=381 lang=java
 *
 * [381] Insert Delete GetRandom O(1) - Duplicates allowed
 */

// @lc code=start
class RandomizedCollection {
    private Random rand;
    private List<Integer> list;
    private Map<Integer, Set<Integer>> map;

    public RandomizedCollection() {
        rand = new Random();
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, new HashSet<>());
            map.get(val).add(list.size());
            list.add(val);
            return true;
        } else {
            map.get(val).add(list.size());
            list.add(val);
            return false;
        }
    }
    
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            // remove the record of val
            int index = map.get(val).iterator().next();
            map.get(val).remove(index);
            if (index < list.size() - 1) {
                // swap val with the last element
                int last = list.get(list.size() - 1);
                list.set(index, last);
                map.get(last).remove(list.size() - 1);
                map.get(last).add(index);
            }
            list.remove(list.size() - 1);
            if (map.get(val).isEmpty()) {
                map.remove(val);
            }
            return true;
        } else {
            return false;
        }
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
// @lc code=end

