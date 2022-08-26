import java.util.*;

/*
 * @lc app=leetcode id=1698 lang=java
 *
 * [1698] Number of Distinct Substrings in a String
 */

// @lc code=start
class Solution {
    public int countDistinct(String s) {
        Set<String> set = new HashSet<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                set.add(s.substring(i, j));
            }
        }

        return set.size();
    }
}
// @lc code=end

