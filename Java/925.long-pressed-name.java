/*
 * @lc app=leetcode id=925 lang=java
 *
 * [925] Long Pressed Name
 */

// @lc code=start
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int p = 0;
        for (int i = 0; i < typed.length(); i++) {
            if (p < name.length() && name.charAt(p) == typed.charAt(i)) {
                p++;
            } else if (i == 0 || typed.charAt(i) != name.charAt(p - 1)) {
                return false;
            }
        }
        return p == name.length();
    }
}
// @lc code=end

