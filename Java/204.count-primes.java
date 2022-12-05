/*
 * @lc app=leetcode id=204 lang=java
 *
 * [204] Count Primes
 */

// @lc code=start
class Solution {
    // O(sqrt(n)loglogn)
    public int countPrimes(int n) {
        int res = 0;
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (!isPrime[i]) {
                for (int j = 2; i * j < n; j++) {
                    // Remove the multiples of this prime
                    isPrime[i * j] = true;
                }
            }
        }
        for (int i = 2; i < n; i++) {
            res += isPrime[i] ? 0 : 1;
        }

        return res;
    }
}
// @lc code=end

