import java.util.HashSet;

/*
 * @lc app=leetcode id=771 lang=java
 *
 * [771] Jewels and Stones
 */

// @lc code=start
class Solution {
    public int numJewelsInStones(String J, String S) {
        if (S == null || S.length() == 0) {
            return 0;
        }
        HashSet<Character> jewels = new HashSet<>();
        int result = 0;
        for (int i = 0; i < J.length(); i++) {
            jewels.add(J.charAt(i));
        }
        for (int i = 0; i < S.length(); i++) {
            if (jewels.contains(S.charAt(i))) {
                result++;
            }
        }
        return result;
    }
}
// @lc code=end

