import java.util.*;

/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start
class Solution {
    // BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int res = 0, n = beginWord.length();
        Set<String> visited = new HashSet<>();
        Deque<String> queue = new LinkedList<>();
        Map<String, Set<String>> map = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < n; i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1, n);
                map.putIfAbsent(pattern, new HashSet<>());
                map.get(pattern).add(word);
            }
        }
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int len = queue.size();
            if (visited.contains(endWord)) {
                return res;
            }
            res++;
            while (len-- > 0) {
                String cur = queue.poll();
                if (visited.contains(cur)) {
                    continue;
                }
                for (int i = 0; i < n; i++) {
                    String pattern = cur.substring(0, i) + "*" + cur.substring(i + 1, n);
                    if (!map.containsKey(pattern)) {
                        continue;
                    }
                    for (String word : map.get(pattern)) {
                        if (visited.contains(word)) {
                            continue;
                        }
                        queue.offer(word);
                    }
                }
                visited.add(cur);
            }
        }

        return 0;
    }
}
// @lc code=end

