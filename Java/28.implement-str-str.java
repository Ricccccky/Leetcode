/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Implement strStr()
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        char[] text = haystack.toCharArray();
        char[] target = needle.toCharArray();
        int[] nextVal = next(target);
        int i = 0;
        int j = 0;
        while (i < text.length) {
            if (text[i] == target[j]) {
                i++;
                j++;
                if (j == target.length) {
                    return i - j;
                }
            } else {
                if (j > 0) {
                    j = nextVal[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }

    private int[] next(char[] needle) {
        int[] result = new int[needle.length];
        result[0] = 0;
        int i = 0;
        int j = 1;
        while (j < result.length) {
            if (needle[j] == needle[i]) {
                result[j] = i + 1;
                i++;
                j++;
            } else {
                if (i == 0) {
                    j++;
                } else {
                    i = result[i - 1];
                }
            }
        }
        return result;
    }
}
// @lc code=end

