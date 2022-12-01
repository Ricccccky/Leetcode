import java.util.*;

/*
 * @lc app=leetcode id=528 lang=java
 *
 * [528] Random Pick with Weight
 */

// @lc code=start
class Solution {
    private int[] freq;
    Random random;

    public Solution(int[] w) {
        this.random = new Random();
        this.freq = new int[w.length];
        this.freq[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            w[i] += w[i - 1];
            freq[i] = w[i];
        }
    }
    
    public int pickIndex() {
        int idx = random.nextInt(this.freq[this.freq.length - 1]) + 1;
        int l = 0, r = this.freq.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (this.freq[mid] == idx) {
                return mid;
            } else if (this.freq[mid] < idx) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
// @lc code=end

