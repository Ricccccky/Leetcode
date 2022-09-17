import java.util.*;

/*
 * @lc app=leetcode id=715 lang=java
 *
 * [715] Range Module
 */

// @lc code=start
class RangeModule {
    private TreeMap<Integer, Integer> ranges;
    public RangeModule() {
        ranges = new TreeMap<>();
    }
    
    public void addRange(int left, int right) {
        if (left == right) {
            return;
        }
        var start = ranges.floorEntry(left);
        var end = ranges.floorEntry(right);
        if (start != null && start.getValue() >= left) {
            left = start.getKey();
        }
        if (end != null && end.getValue() > right) {
            right = end.getValue();
        }
        ranges.put(left, right);
        for (Integer i = ranges.higherKey(left); i != null && i <= right;) {
            ranges.remove(i);
            i = ranges.higherKey(i);
        }
    }
    
    public boolean queryRange(int left, int right) {
        var entry = ranges.floorEntry(left);
        if (entry == null) {
            return false;
        }

        return entry.getValue() >= right;
    }
    
    public void removeRange(int left, int right) {
        var start = ranges.floorEntry(left);
        var end = ranges.floorEntry(right);
        if (start != null && start.getValue() > left) {
            ranges.put(start.getKey(), left);
        }
        if (end != null && end.getValue() > right) {
            ranges.put(right, end.getValue());
        }
        for (Integer i = ranges.higherKey(left - 1); i != null && i < right;) {
            ranges.remove(i);
            i = ranges.higherKey(i);
        }
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
// @lc code=end

