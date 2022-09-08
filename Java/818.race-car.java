/*
 * @lc app=leetcode id=818 lang=java
 *
 * [818] Race Car
 */

// @lc code=start
class Solution {
    // DP
    int[] dp = new int[10001];
    public int racecar(int target) {
        if (dp[target] > 0) {
            return dp[target];
        }
        int n = (int)(Math.log(target) / Math.log(2) + 1);
        if (target == (1 << n) - 1) {
            dp[target] = n;
        } else {
            // Rush to 2^n - 1 via n steps and turn back to approach target
            int remain = (1 << n) - 1 - target;
            dp[target] = racecar(remain) + n + 1;
            for (int m = 0; m < n - 1; m++) {
                /** 
                 * Rush to 2^(n - 1) - 1 via n - 1 steps
                 * Turn back and move backward m steps
                 * Turn back and approach from point 2^(n - 1) - 1 - 2^m - 1
                **/
                remain = (1 << (n - 1)) - 1;
                remain -= (1 << m) - 1;
                remain = target - remain;
                dp[target] = Math.min(dp[target], racecar(remain) + n + m + 1);
            }
        }

        return dp[target];
    }

    // BFS
    // public int racecar(int target) {
    //     int result = 0;
    //     Deque<int[]> queue = new LinkedList<>();
    //     Set<String> visited = new HashSet<>();
    //     queue.offer(new int[] {0, 1});
    //     visited.add(0 + "#" + 1);
    //     while (!queue.isEmpty()) {
    //         int len = queue.size();
    //         while (len-- > 0) {
    //             int[] top = queue.poll();
    //             if (top[0] == target) {
    //                 return result;
    //             }
    //             int[] next = new int[] {top[0] + top[1], top[1] * 2};
    //             String key = next[0] + "#" + next[1];
    //             if (!visited.contains(key) && next[0] > 0 && next[0] < 2 * target << 1) {
    //                 queue.offer(next);
    //                 visited.add(key);
    //             }
    //             next = new int[] {top[0], top[1] > 0 ? -1 : 1};
    //             key = next[0] + "#" + next[1];
    //             if (!visited.contains(key) && next[0] > 0 && next[0] < 2 * target) {
    //                 queue.offer(next);
    //                 visited.add(key);
    //             }
    //         }
    //         result++;
    //     }

    //     return -1;
    // }
}
// @lc code=end

