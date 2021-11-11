import java.util.*;

/*
 * @lc app=leetcode id=299 lang=java
 *
 * [299] Bulls and Cows
 */

// @lc code=start
class Solution {
    public String getHint(String secret, String guess) {
        int[] nums = new int[10];
        int numBull = 0, numCow = 0;
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                numBull++;
            } else {
                if (nums[s - '0'] < 0) {
                    numCow++;
                }
                if (nums[g - '0'] > 0) {
                    numCow++;
                }
                nums[s - '0']++;
                nums[g - '0']--;
            }
        }

        return numBull + "A" + numCow + "B";
    }
}
// @lc code=end

