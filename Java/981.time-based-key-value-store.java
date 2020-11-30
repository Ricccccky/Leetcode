import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
 * @lc app=leetcode id=981 lang=java
 *
 * [981] Time Based Key-Value Store
 */

// @lc code=start
class TimeMap {
    Map<String, TreeMap<Integer, String>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        TreeMap<Integer, String> tree = map.get(key);
        Integer value = tree.floorKey(timestamp);
        if (value != null) {
            return tree.get(value);
        } else {
            return "";
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
// @lc code=end

