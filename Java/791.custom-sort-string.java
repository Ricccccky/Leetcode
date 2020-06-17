import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=791 lang=java
 *
 * [791] Custom Sort String
 */

// @lc code=start
class Solution {
    public String customSortString(String S, String T) {
        if (T == null) {
            return T;
        }
        StringBuilder result = new StringBuilder();
        HashMap<Character, Integer> temp = new HashMap<>();
        for (int i = 0; i < T.length(); i++) {
            temp.put(T.charAt(i), temp.getOrDefault(T.charAt(i), 0) + 1);
        }
        for (int i = 0; i < S.length(); i++) {
            if (!temp.containsKey(S.charAt(i))) {
                continue;
            }
            for (int j = 0; j < temp.get(S.charAt(i)); j++) {
                result.append(S.charAt(i));
            }
            temp.remove(S.charAt(i));
        }
        for (Map.Entry<Character,Integer> k : temp.entrySet()) {
            for (int i = 0; i < k.getValue(); i++) {
                result.append(k.getKey());
            }
        }
        return result.toString();
    }
}
// @lc code=end

