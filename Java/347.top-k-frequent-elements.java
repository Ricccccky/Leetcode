import java.util.*;

/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (buckets[entry.getValue()] == null) {
                buckets[entry.getValue()] = new ArrayList<>();
            }
            buckets[entry.getValue()].add(entry.getKey());
        }
        for (int i = buckets.length - 1; i >= 0 && k > 0; i--) {
            if (buckets[i] == null) {
                continue;
            }
            if (k >= buckets[i].size()) {
                res.addAll(buckets[i]);
                k -= buckets[i].size();
            } else {
                res.addAll(buckets[i].subList(0, k));
                k = 0;
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
// @lc code=end

