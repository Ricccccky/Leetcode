import java.util.*;

/*
 * @lc app=leetcode id=269 lang=java
 *
 * [269] Alien Dictionary
 */

// @lc code=start
class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        int[] inDegree = new int[26];
        StringBuilder sb = new StringBuilder();
        // build graph for topological sort
        for (int i = 0; i < words.length; i++) {
            boolean used = false;
            int j = 0;
            for (; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                if (!used && i > 0 && j < words[i - 1].length() && c != words[i - 1].charAt(j)) {
                    /*
                     * We can compare the jth letter between words[i] and words[i - 1]
                     * only the first different comparable letter can be compared
                     * 
                     * After that, we shoud dicard words[i] and move to words[i + 1]
                     * jth letter in words[i - 1] prior to jth letter in words[i]
                     */
                    if (!graph.get(words[i - 1].charAt(j)).contains(c)) {
                        inDegree[c - 'a']++;
                        graph.get(words[i - 1].charAt(j)).add(c);
                    }
                    used = true;
                }
                graph.putIfAbsent(c, new HashSet<>());
            }
            // words[i] is shorter than words[i - 1] and no letter comparsion, order conflict
            if (i > 0 && j < words[i - 1].length() && !used) {
                return "";
            }
        }

        // topological sort
        for (Map.Entry<Character, Set<Character>> entry : graph.entrySet()) {
            if (inDegree[entry.getKey() - 'a'] == 0) {
                sb.append(entry.getKey());
                queue.offer(entry.getKey());
            }
        }
        while (!queue.isEmpty()) {
            char c = queue.poll();
            for (Character next : graph.get(c)) {
                inDegree[next - 'a']--;
                if (inDegree[next - 'a'] == 0) {
                    sb.append(next);
                    queue.offer(next);
                }
            }
        }
        if (sb.length() == graph.keySet().size()) {
            return sb.toString();
        }

        return "";
    }
}
// @lc code=end

