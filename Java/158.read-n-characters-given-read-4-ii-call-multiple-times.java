/*
 * @lc app=leetcode id=158 lang=java
 *
 * [158] Read N Characters Given read4 II - Call Multiple Times
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
    // State of last read4()
    private char[] buf4 = new char[4];
    private int readLen = 4;
    private int buf4Offset = 0;

    public int read(char[] buf, int n) {
        int offset = 0;
        while (offset < n && readLen > 0) {
            if (buf4Offset == 0) {
                readLen = read4(buf4);
            }
            if (readLen == 0) {
                break;
            }
            while (offset < n && buf4Offset < readLen) {
                buf[offset++] = buf4[buf4Offset++];
            }
            if (buf4Offset == readLen) {
                buf4Offset = 0;
            }
        }

        return offset;
    }
}
// @lc code=end

