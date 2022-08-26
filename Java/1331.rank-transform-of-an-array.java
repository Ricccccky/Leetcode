import java.util.*;

/*
 * @lc app=leetcode id=1331 lang=java
 *
 * [1331] Rank Transform of an Array
 */

// @lc code=start
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] dummy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(dummy);
        for (int n : dummy) {
            map.putIfAbsent(n, map.size() + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}
// @lc code=end

