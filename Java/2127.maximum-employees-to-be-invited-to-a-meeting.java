import java.util.*;

/*
 * @lc app=leetcode id=2127 lang=java
 *
 * [2127] Maximum Employees to Be Invited to a Meeting
 */

// @lc code=start
class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int result1 = 0, result2 = 0;
        int[] inDegree = new int[n];
        int[] dp = new int[n];
        boolean[] visited = new boolean[n];
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            inDegree[favorite[i]]++;
        }
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                visited[i] = true;
            }
        }
        while (!queue.isEmpty()) {
            int i = queue.poll();
            int j = favorite[i];
            dp[j] = Math.max(dp[j], dp[i] + 1);
            if (--inDegree[j] == 0) {
                queue.offer(j);
                visited[j] = true;
            }
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int len = 0;
                for (int j = i; !visited[j]; j = favorite[j]) {
                    visited[j] = true;
                    len++;
                }
                if (len == 2) {
                    // loops of length=2
                    result1 += len + dp[i] + dp[favorite[i]];
                } else {
                    // loops of length>2
                    result2 = Math.max(result2, len);
                }
            }
        }
        
        return Math.max(result1, result2);
    }
}
// @lc code=end

