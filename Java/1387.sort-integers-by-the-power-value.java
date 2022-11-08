import java.util.*;

/*
 * @lc app=leetcode id=1387 lang=java
 *
 * [1387] Sort Integers by The Power Value
 */

// @lc code=start
class Solution {
    private Map<Integer, Integer> map = new HashMap<>();
    public int getKth(int lo, int hi, int k) {
        int[][] arr = new int[hi - lo + 1][2];
        int ptr = 0;
        for (int i = lo; i <= hi; i++) {
            arr[ptr++] = new int[] {i, getPower(i)};
        }
        Arrays.sort(arr, (x, y) -> x[1] == y[1] ? x[0] - y[0] : x[1] - y[1]);

        return arr[k - 1][0];
    }

    private int getPower(int x) {
        if (x == 1) {
            return 0;
        }
        if (map.containsKey(x)) {
            return map.get(x);
        }
        if (x % 2 == 1) {
            map.put(x, getPower(x * 3 + 1) + 1);
        } else {
            map.put(x, getPower(x / 2) + 1);
        }

        return map.get(x);
    }
}
// @lc code=end

