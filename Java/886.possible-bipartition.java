import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * @lc app=leetcode id=886 lang=java
 *
 * [886] Possible Bipartition
 */

// @lc code=start
class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] like = new int[N + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] dislike : dislikes) {
            map.putIfAbsent(dislike[0], new ArrayList<>());
            map.putIfAbsent(dislike[1], new ArrayList<>());
            map.get(dislike[0]).add(dislike[1]);
            map.get(dislike[1]).add(dislike[0]);
        }
        for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
            if (like[e.getKey()] != 0) {
                continue;
            }
            Queue<Integer> queue = new LinkedList<>();
            like[e.getKey()] = 1;
            queue.offer(e.getKey());
            while (!queue.isEmpty()) {
                int top = queue.poll();
                for (int p : map.get(top)) {
                    if (like[p] == 0) {
                        like[p] = -like[top];
                        queue.offer(p);
                    } else if (like[p] == like[top]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
// @lc code=end

