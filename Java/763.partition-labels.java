import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=763 lang=java
 *
 * [763] Partition Labels
 */

// @lc code=start
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        int[] index = new int[26];
        for (int i = 0; i < S.length(); i++) {
            index[S.charAt(i) - 'a'] = i;
        }
        int p1 = 0, p2 = 0;
        for (int i = 0; i < S.length(); i++) {
            p2 = Math.max(p2, index[S.charAt(i) - 'a']);
            if (i == p2) {
                result.add(p2 - p1 + 1);
                p1 = i + 1;
            }
        }
        return result;
    }
}
// @lc code=end

