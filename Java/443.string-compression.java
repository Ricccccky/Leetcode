/*
 * @lc app=leetcode id=443 lang=java
 *
 * [443] String Compression
 */

// @lc code=start
class Solution {
    // public int compress(char[] chars) {
    //     StringBuilder sb = new StringBuilder();
    //     int n = chars.length;
    //     int count = 1;
    //     char prev = chars[0];
    //     for (int i = 1; i < n; i++) {
    //         if (chars[i] == prev) {
    //             count++;
    //         } else {
    //             if (count > 1) {
    //                 sb.append(prev)
    //                 .append(String.valueOf(count));
    //             } else {
    //                 sb.append(prev);
    //             }
    //             prev = chars[i];
    //             count = 1;
    //         }
    //     }
    //     if (count > 1) {
    //         sb.append(chars[n - 1]).append(String.valueOf(count));
    //     } else {
    //         sb.append(chars[n - 1]);
    //     }
    //     for (int i = 0; i < sb.length(); i++) {
    //         chars[i] = sb.charAt(i);
    //     }

    //     return sb.length();
    // }

    public int compress(char[] chars) {
        int n = chars.length;
        int res = 0;
        int count = 1;
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || chars[i + 1] != chars[i]) {
                chars[res++] = chars[i];
                if (count > 1) {
                    for (char c : String.valueOf(count).toCharArray()) {
                        chars[res++] = c;
                    }
                }
                count = 1;
            } else {
                count++;
            }
        }

        return res;
    }
}
// @lc code=end

