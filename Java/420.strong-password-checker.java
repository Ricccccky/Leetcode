/*
 * @lc app=leetcode id=420 lang=java
 *
 * [420] Strong Password Checker
 */

// @lc code=start
class Solution {
    public int strongPasswordChecker(String password) {
        char[] arr = password.toCharArray();
        int n = arr.length;
        int[] repeat = new int[n];
        int result = 0, lower = 1, upper = 1, digit = 1;
        for (int i = 0; i < n;) {
            if (Character.isUpperCase(arr[i])) {
                upper = 0;
            }
            if (Character.isLowerCase(arr[i])) {
                lower = 0;
            }
            if (Character.isDigit(arr[i])) {
                digit = 0;
            }
            int j = i;
            while (i < n && arr[i] == arr[j]) {
                i++;
            }
            repeat[j] = i - j;
        }

        int totalMissing = lower + upper + digit;
        if (n < 6) {
            result += totalMissing + Math.max(0, 6 - (n + totalMissing));
        } else {
            int over_len = Math.max(0, n - 20), left_over = 0;
            result += over_len;

            // Transfer all repeat[i] > 3 to the form of 3m+2, delete redundant 1~2 characters
            for (int k = 1; k < 3; k++) {
                for (int i = 0; i < n && over_len > 0; i++) {
                    if (repeat[i] < 3 || repeat[i] % 3 != (k - 1)) {
                        continue;
                    }
                    repeat[i] -= Math.min(over_len, k);
                    over_len -= k;
                }
            }
            for (int i = 0; i < n; i++) {
                if (repeat[i] >= 3 && over_len > 0) {
                    int deleted = repeat[i] - 2;
                    repeat[i] -= over_len;
                    over_len -= deleted;
                }

                // Cut 3m+2 to m+1 sequences of length 2 via m replacement
                if (repeat[i] >= 3) {
                    left_over += repeat[i] / 3;
                }
            }
            // Missing characters can be used in replacement
            result += Math.max(totalMissing, left_over);
        }

        return result;

    }
}
// @lc code=end

