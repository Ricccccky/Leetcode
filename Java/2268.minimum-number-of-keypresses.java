import java.util.*;

/*
 * @lc app=leetcode id=2268 lang=java
 *
 * [2268] Minimum Number of Keypresses
 */

// @lc code=start
class Solution {
    public int minimumKeypresses(String s) {
        int result = 0;
        int count = 0;  // Number of buttons mapped
        Map<Character, Integer> freq = new HashMap<>();
        PriorityQueue<Character> queue = new PriorityQueue<>((x, y) -> freq.get(y) - freq.get(x));
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        for (char c : freq.keySet()) {
            queue.offer(c);
        }
        while (!queue.isEmpty()) {
            char c = queue.poll();
            result += (count / 9 + 1) * freq.get(c);
            count++;
        }

        return result;
    }
}
// @lc code=end

