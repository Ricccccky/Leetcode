/*
 * @lc app=leetcode id=157 lang=java
 *
 * [157] Read N Characters Given Read4
 */

// @lc code=start
/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int offset = 0, len = 4;
        char[] buf4 = new char[4];
        while (len == 4) {
            len = read4(buf4);
            for (int i = 0; i < len; i++) {
                if (offset == n) {
                    return offset;
                }
                buf[offset++] = buf4[i];
            }
        }

        return offset;
    }
}
// @lc code=end

