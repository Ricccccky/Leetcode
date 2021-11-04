import java.util.*;

/*
 * @lc app=leetcode id=763 lang=java
 *
 * [763] Partition Labels
 */

// @lc code=start
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        int[] pos = new int[26];
        for (int i = 0; i < S.length(); i++) {
            pos[S.charAt(i) - 'a'] = i;
        }
        int ptr = 0;
        int start = 0;
        for (int i = 0; i < S.length(); i++) {
            ptr = Math.max(ptr, pos[S.charAt(i) - 'a']);
            if (ptr == i) {
                res.add(ptr - start + 1);
                start = ptr + 1;
            }
        }

        return res;
    }
}
// @lc code=end

