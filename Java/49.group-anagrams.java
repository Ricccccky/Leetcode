import java.util.*;

/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count.length; i++) {
                sb.append(count[i])
                .append("#");
            }
            map.putIfAbsent(sb.toString(), new ArrayList<>());
            map.get(sb.toString()).add(str);
        }
        for (var entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
}
// @lc code=end

