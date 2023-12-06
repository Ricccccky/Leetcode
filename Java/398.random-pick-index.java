/*
 * @lc app=leetcode id=398 lang=java
 *
 * [398] Random Pick Index
 */

// @lc code=start

import java.util.*;

class Solution {
    private Map<Integer, List<Integer>> freq;

    public Solution(int[] nums) {
        freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            freq.putIfAbsent(nums[i], new ArrayList<>());
            freq.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        Random rand = new Random();
        int idx = rand.nextInt(freq.get(target).size());
        return freq.get(target).get(idx);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
// @lc code=end

