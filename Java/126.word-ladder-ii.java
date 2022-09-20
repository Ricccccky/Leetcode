import java.util.*;

/*
 * @lc app=leetcode id=126 lang=java
 *
 * [126] Word Ladder II
 */

// @lc code=start
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        Set<String> words = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Map<String, List<String>> map = new HashMap<>();
        Deque<String> queue = new LinkedList<>();
        if (!words.contains(endWord)) {
            return result;
        }
        visited.add(beginWord);
        queue.offer(beginWord);
        path.add(endWord);
        while (!queue.isEmpty()) {
            int len = queue.size();
            Set<String> removableWords = new HashSet<>();
            while (len-- > 0) {
                String top = queue.poll();
                char[] arr = top.toCharArray();
                // find all transformable word with top
                for (int i = 0; i < arr.length; i++) {
                    char old = arr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) {
                            continue;
                        }
                        arr[i] = c;
                        String next = String.valueOf(arr);
                        if (words.contains(next) && !next.equals(beginWord)) {
                            map.computeIfAbsent(next, x -> new ArrayList<>()).add(top);
                            removableWords.add(next);
                            if (!visited.contains(next)) {
                                queue.offer(next);
                                visited.add(next);
                            }
                        }
                    }
                    arr[i] = old;
                }
            }
            // remove cycle
            words.removeAll(removableWords);
        }
        if (!map.containsKey(endWord)) {
            return result;
        }
        dfs(map, result, path, beginWord, endWord);

        return result;
    }

    private void dfs(Map<String, List<String>> map, List<List<String>> result, List<String> path, String beginWord, String endWord) {
        if (path.get(path.size() - 1).equals(beginWord)) {
            List<String> newPath = new ArrayList<>(path);
            Collections.reverse(newPath);
            result.add(newPath);
            return;
        }
        // backtracking from endWord to beginWord
        for (String word : map.get(endWord)) {
            path.add(word);
            dfs(map, result, path, beginWord, word);
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end

