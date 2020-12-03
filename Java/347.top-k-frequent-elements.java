import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] lists = new List[nums.length + 1];

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        System.out.println(map);
        for (Integer key : map.keySet()) {
            int freq = map.get(key);
            if (lists[freq] == null) {
                lists[freq] = new ArrayList<>();
            }
            lists[freq].add(key);
        }

        for (int i = nums.length, count = 0; i >= 0 && count < k; i--) {
            if (lists[i] != null) {
                result.addAll(lists[i]);
                count += lists[i].size();
            }
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}
// @lc code=end

