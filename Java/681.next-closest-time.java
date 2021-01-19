import java.util.TreeSet;

/*
 * @lc app=leetcode id=681 lang=java
 *
 * [681] Next Closest Time
 */

// @lc code=start
class Solution {
    public String nextClosestTime(String time) {
        char[] res = time.toCharArray();
        TreeSet<Integer> set = new TreeSet<>();
        for (char c : res) {
            if (c != ':') {
                set.add(c - '0');
            }
        }
        
        for (int i = time.length() - 1; i >= 0; i--) {
            char c = time.charAt(i);
            if (c == ':') {
                continue;
            }
            Integer ceil = set.ceiling(c - '0' + 1);
            if (ceil == null || (i == 0 && ceil > 2) || (i == 3 && ceil > 5) || (res[0] == '2' && (i == 1 && ceil > 4))) {
                res[i] = (char)(set.first() + '0');
            } else {
                res[i] = (char)(ceil + '0');
                return String.valueOf(res);
            }
        }

        return String.valueOf(res);
    }
}
// @lc code=end

