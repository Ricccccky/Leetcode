import java.util.*;

/*
 * @lc app=leetcode id=1352 lang=java
 *
 * [1352] Product of the Last K Numbers
 */

// @lc code=start
class ProductOfNumbers {
    private Map<Integer, Integer> map;
    public ProductOfNumbers() {
        map = new HashMap<>();
        map.put(0, 1);
    }
    
    public void add(int num) {
        if (num == 0) {
            map.clear();
            map.put(0, 1);
            
            return;
        }
        int prev = map.get(map.size() - 1);
        map.put(map.size(), prev * num);
    }
    
    public int getProduct(int k) {
        if (k >= map.size()) {
            return 0;
        }
        
        return map.get(map.size() - 1) / map.get(map.size() - 1 - k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
// @lc code=end

