/*
 * @lc app=leetcode id=1093 lang=java
 *
 * [1093] Statistics from a Large Sample
 */

// @lc code=start
class Solution {
    public double[] sampleStats(int[] count) {
        int max = 0;
        int min = 255;
        int mode = 0;
        int numMode = 0;
        double median = 0;
        long sum = 0;
        long num = 0;
        for (int i = 0; i < 256; i++) {
            if (count[i] != 0) {
                max = Math.max(max, i);
                min = Math.min(min, i);
                sum += count[i] * i;
                num += count[i];
                if (numMode < count[i]) {
                    numMode = count[i];
                    mode = i;
                }
            }
            if (i > 0) {
                count[i] += count[i - 1];
            }
        }
        if (num % 2 == 1) {
            long index = num / 2;
            for (int i = 0; i < 256; i++) {
                if (index >= count[i]) {
                    median = (double)i + 1;
                }
            }
        } else {
            int med1 = 0;
            int med2 = 0;
            long index1 = num / 2;
            long index2 = (num - 1) / 2;
            for (int i = 0; i < 256; i++) {
                if (index1 >= count[i]) {
                    med1 = i + 1;
                }
                if (index2 >= count[i]) {
                    med2 = i + 1;
                }
            }
            median = (double)(med1 + med2) / 2;
        }

        return new double[] {min, max, (double)sum / num, median, mode};
    }
}
// @lc code=end

