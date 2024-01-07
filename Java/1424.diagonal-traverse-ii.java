import java.util.*;

/*
 * @lc app=leetcode id=1424 lang=java
 *
 * [1424] Diagonal Traverse II
 */

// @lc code=start
class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> matrix = new HashMap<>();
        int n = nums.size(), max = 0, m = 0, p = 0;
        int[] res;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                max = Math.max(max, i + j);
                matrix.putIfAbsent(i + j, new ArrayList<>());
                matrix.get(i + j).add(nums.get(i).get(j));
                m++;
            }
        }
        res = new int[m];
        for (int i = 0; i <= max; i++) {
            for (int j : matrix.get(i)) {
                res[p++] = j;
            }
        }

        return res;
    }
}
// @lc code=end

