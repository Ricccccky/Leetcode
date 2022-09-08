import java.util.*;

/*
 * @lc app=leetcode id=1291 lang=java
 *
 * [1291] Sequential Digits
 */

// @lc code=start
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String sequence = "123456789";
        List<Integer> result = new ArrayList<>();
        int lowerLen = Integer.toString(low).length();
        int upperLen = Integer.toString(high).length();
        for (int len = lowerLen; len <= upperLen; len++) {
            int RL = (int)Math.pow(10, len - 1);
            int l = 0, r = 0;
            int num = 0;
            while (r < sequence.length()) {
                num = 10 * num + (sequence.charAt(r) - '0');
                r++;
                if (r - l == len) {
                    if (num >= low && num <= high) {
                        result.add(num);
                    }
                    num = num - (sequence.charAt(l) - '0') * RL;
                    l++;
                }
            }

            // for (int i = 0; i < sequence.length() + 1 - len; i++) {
            //     int num = Integer.parseInt(sequence.substring(i, i + len));
            //     if (num >= low && num <= high) {
            //         result.add(num);
            //     }
            // }
        }

        return result;
    }
}
// @lc code=end

