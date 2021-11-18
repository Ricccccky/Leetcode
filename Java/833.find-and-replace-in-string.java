import java.util.*;

/*
 * @lc app=leetcode id=833 lang=java
 *
 * [833] Find And Replace in String
 */

// @lc code=start
class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        List<int[]> pairs = new ArrayList<>();
        for (int i = 0; i < indices.length; i++) {
            pairs.add(new int[] {indices[i], i});
        }
        Collections.sort(pairs, (x, y) -> Integer.compare(y[0], x[0]));
        for (int[] pair : pairs) {
            String source = sources[pair[1]];
            String target = targets[pair[1]];
            if (s.substring(pair[0], pair[0] + source.length()).equals(source)) {
                s = s.substring(0, pair[0]) + target + s.substring(pair[0] + source.length());
            }
        }

        return s;
    }
}
// @lc code=end

