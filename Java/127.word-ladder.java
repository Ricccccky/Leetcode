import java.util.*;

/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int res = 1;
        Map<String, List<String>> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        wordList.add(beginWord);
        for (String word : wordList) {
            List<String> list = new ArrayList<>();
            for (String next : wordList) {
                if (transformable(word, next)) {
                    list.add(next);
                }
            }
            map.put(word, list);
        }
        queue.offer(beginWord);
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            int len = queue.size();
            res++;
            while (len-- > 0) {
                String cur = queue.poll();
                for (String word : map.get(cur)) {
                    if (word.equals(endWord)) {
                        return res;
                    } else if (visited.contains(word)) {
                        continue;
                    } else {
                        queue.offer(word);
                        visited.add(word);
                    }
                }
            }
        }

        return 0;
    }

    private boolean transformable(String x, String y) {
        int diff = 0;
        int len = x.length();
        for (int i = 0; i < len && diff <= 1; i++) {
            if (x.charAt(i) != y.charAt(i)) {
                diff++;
            }
        }

        return diff == 1;
    }
}
// @lc code=end

