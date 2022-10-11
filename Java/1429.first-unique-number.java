import java.util.*;

/*
 * @lc app=leetcode id=1429 lang=java
 *
 * [1429] First Unique Number
 */

// @lc code=start
class FirstUnique {
    private Set<Integer> set;
    private Map<Integer, Boolean> map;
    public FirstUnique(int[] nums) {
        set = new LinkedHashSet<>();
        map = new HashMap<>();
        for (int num : nums) {
            this.add(num);
        }
    }
    
    public int showFirstUnique() {
        if (!set.isEmpty()) {
            return set.iterator().next();
        }

        return -1;
    }
    
    public void add(int value) {
        if (!map.containsKey(value)) {
            set.add(value);
            map.put(value, true);
        } else {
            map.put(value, false);
            set.remove(value);
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
// @lc code=end

