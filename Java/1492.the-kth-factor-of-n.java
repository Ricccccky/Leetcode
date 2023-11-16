/*
 * @lc app=leetcode id=1492 lang=java
 *
 * [1492] The kth Factor of n
 */

// @lc code=start

import java.util.*;

class Solution {
    // O(n)
    // public int kthFactor(int n, int k) {
    //     for (int i = 1; i <= n; i++) {
    //         if (n % i == 0) {
    //             k--;
    //         }
    //         if (k == 0) {
    //             return i;
    //         }
    //     }

    //     return -1;
    // }
    
    // O(sqrt(n)logk)
    public int kthFactor(int n, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                maxHeap.add(i);
                if (i != n / i) {
                    maxHeap.add(n / i);
                }
            }
            while (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        return maxHeap.size() < k? -1 : maxHeap.peek();
    }
}
// @lc code=end

