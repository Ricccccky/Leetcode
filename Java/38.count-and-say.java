/*
 * @lc app=leetcode id=38 lang=java
 *
 * [38] Count and Say
 */

// @lc code=start
class Solution {
    public String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder temp = new StringBuilder();
            char prev = result.charAt(0);
            int count = 0;
            for (int j = 0; j < result.length(); j++) {
                if (prev == result.charAt(j)) {
                    count++;
                } else {
                    temp.append("" + count + prev);
                    prev = result.charAt(j);
                    count = 1;
                }
            }
            temp.append("" + count + prev);
            result = temp.toString();
        }
        return result.toString();
    }
}
// @lc code=end

