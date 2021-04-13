import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=1424 lang=java
 *
 * [1424] Diagonal Traverse II
 */

// @lc code=start
class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int num = 0;
        for (int i = nums.size() - 1; i >= 0; i--) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                num = Math.max(num, i + j);
                map.putIfAbsent(i + j, new ArrayList<>());
                map.get(i + j).add(nums.get(i).get(j));
            }
        }
        for (int i = 0; i <= num; i++) {
            res.addAll(map.get(i));
        }

        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
// @lc code=end

