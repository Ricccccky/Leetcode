import java.util.List;

/*
 * @lc app=leetcode id=539 lang=java
 *
 * [539] Minimum Time Difference
 */

// @lc code=start
class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] occur = new boolean[24 * 60];
        int result = occur.length;
        int pre = 0, first = -1;
        for (String ts : timePoints) {
            String[] arr = ts.split(":");
            int index = Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
            if (occur[index]) {
                return 0;
            }
            occur[index] = true;
        }
        for (int i = 0; i < occur.length; i++) {
            if (occur[i]) {
                if (first == -1) {
                    first = i;
                } else {
                    result = Math.min(result, i - pre);
                }
                pre = i;
            }
        }

        return Math.min(result, first + occur.length - pre);
    }
}
// @lc code=end

