import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=996 lang=java
 *
 * [996] Number of Squareful Arrays
 */

// @lc code=start
class Solution {
    public int numSquarefulPerms(int[] A) {
        int res = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Set<Integer>> pairs = new HashMap<>();
        for (int num : A) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            pairs.putIfAbsent(num, new HashSet<>());
        }
        for (int x : freq.keySet()) {
            for (int y : freq.keySet()) {
                double s = Math.sqrt(x + y);
                if (s == Math.floor(s)) {
                    pairs.get(x).add(y);
                    pairs.get(y).add(x);
                }
            }
        }
        for (int num : freq.keySet()) {
            res += dfs(freq, pairs, num, A.length - 1);
        }

        return res;
    }

    private int dfs(Map<Integer, Integer> freq, Map<Integer, Set<Integer>> pairs, int num, int left) {
        freq.put(num, freq.get(num) - 1);
        int res = 0;
        if (left == 0) {
            res++;
        } else {
            for (int next : pairs.get(num)) {
                if (freq.get(next) != 0) {
                    res += dfs(freq, pairs, next, left - 1);
                }
            }
        }
        freq.put(num, freq.get(num) + 1);
        return res;
    }
}
// @lc code=end

