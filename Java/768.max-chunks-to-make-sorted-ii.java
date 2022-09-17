import java.util.*;

/*
 * @lc app=leetcode id=768 lang=java
 *
 * [768] Max Chunks To Make Sorted II
 */

// @lc code=start
class Solution {
    public int maxChunksToSorted(int[] arr) {
        // Monotonic stack, O(n)
        Deque<Integer> stack = new LinkedList<>();
        for (int num : arr) {
            int max = num;
            while (!stack.isEmpty() && stack.peek() > num) {
                max = Math.max(max, stack.pop());
            }
            stack.push(max);
        }

        return stack.size();
        
        // O(nlogn)
        // int result = 0;
        // int prefixSum1 = 0, prefixSum2 = 0;
        // int[] sortedArr = arr.clone();
        // Arrays.sort(sortedArr);
        // for (int i = 0; i < arr.length; i++) {
        //     prefixSum1 += arr[i];
        //     prefixSum2 += sortedArr[i];
        //     if (prefixSum1 == prefixSum2) {
        //         result++;
        //     }
        // }

        // return result;
    }
}
// @lc code=end

