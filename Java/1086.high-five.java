import java.util.*;

/*
 * @lc app=leetcode id=1086 lang=java
 *
 * [1086] High Five
 */

// @lc code=start
class Solution {
    public int[][] highFive(int[][] items) {
        TreeMap<Integer, Queue<Integer>> map = new TreeMap<>();
        for (int[] item : items) {
            if (!map.containsKey(item[0])) {
                map.put(item[0], new PriorityQueue<>((x, y) -> y - x));
            }
            map.get(item[0]).offer(item[1]);
        }
        int[][] result = new int[map.size()][2];
        int ptr = 0;
        for (var entry : map.entrySet()) {
            int sum = 0;
            result[ptr][0] = entry.getKey();
            for (int i = 0; i < 5; i++) {
                sum += entry.getValue().poll();
            }
            result[ptr++][1] = sum / 5;
        }

        return result;
    }
}
// @lc code=end

