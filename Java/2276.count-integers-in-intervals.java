import java.util.*;

/*
 * @lc app=leetcode id=2276 lang=java
 *
 * [2276] Count Integers in Intervals
 */

// @lc code=start
class CountIntervals {
    TreeMap<Integer, Integer> map;
    int count;

    public CountIntervals() {
        map = new TreeMap<>();
        count = 0;
    }
    
    public void add(int left, int right) {
        Map.Entry<Integer, Integer> entry = map.floorEntry(left);
        if (entry == null || entry.getValue() < left) {
            entry = map.ceilingEntry(left);
        }
        while (entry != null && entry.getKey() <= right) {
            left = Math.min(left, entry.getKey());
            right = Math.max(right, entry.getValue());
            map.remove(entry.getKey());
            count -= entry.getValue() - entry.getKey() + 1;
            entry = map.ceilingEntry(entry.getKey());
        }
        map.put(left, right);
        count += right - left + 1;
    }
    
    public int count() {
        return count;
    }
}

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */
// @lc code=end

