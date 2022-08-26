import java.util.*;
import java.util.stream.*;

/*
 * @lc app=leetcode id=1583 lang=java
 *
 * [1583] Count Unhappy Friends
 */

// @lc code=start
class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> pref =  new ArrayList<>();
        for (int[] pair : pairs) {
            map.put(pair[0], pair[1]);
            map.put(pair[1], pair[0]);
        }
        for (int[] p : preferences) {
            pref.add(Arrays.stream(p).boxed().collect(Collectors.toList()));
        }
        for (int[] pair : pairs) {
            int x = pair[0];
            int y = pair[1];
            for (int u : preferences[x]) {
                if (u == y) {
                    break;
                }
                int v = map.get(u);
                if (pref.get(x).indexOf(u) < pref.get(x).indexOf(y) && pref.get(u).indexOf(x) < pref.get(u).indexOf(v)) {
                    result++;
                    break;
                }
            }
            for (int u : preferences[y]) {
                if (u == x) {
                    break;
                }
                int v = map.get(u);
                if (pref.get(y).indexOf(u) < pref.get(y).indexOf(x) && pref.get(u).indexOf(y) < pref.get(u).indexOf(v)) {
                    result++;
                    break;
                }
            }
        }

        return result;
    }
}
// @lc code=end

