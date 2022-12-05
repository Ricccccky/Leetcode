import java.util.*;

/*
 * @lc app=leetcode id=1366 lang=java
 *
 * [1366] Rank Teams by Votes
 */

// @lc code=start
class Solution {
    public String rankTeams(String[] votes) {
        Map<Character, int[]> count = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int len = votes[0].length();
        for (String vote : votes) {
            for (int i = 0; i < len; i++) {
                char c = vote.charAt(i);
                count.putIfAbsent(c, new int[len]);
                count.get(c)[i]++;
            }   
        }
        List<Character> list = new ArrayList<>(count.keySet());
        list.sort((x, y) -> {for (int i = 0; i < len; i++) {
            if (count.get(x)[i] != count.get(y)[i]) {
                return count.get(y)[i] - count.get(x)[i];
            }
        }
        return x - y;});
        for (char c : list) {
            sb.append(c);
        }

        return String.valueOf(sb.toString());
    }
}
// @lc code=end

