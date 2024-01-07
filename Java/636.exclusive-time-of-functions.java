/*
 * @lc app=leetcode id=636 lang=java
 *
 * [636] Exclusive Time of Functions
 */

// @lc code=start

import java.util.*;

class Solution {
    class Log {
        int id, ts;
        boolean isStart;

        public Log(String s) {
            String[] arr = s.split(":");
            id = Integer.valueOf(arr[0]);
            isStart = arr[1].equals("start");
            ts = Integer.valueOf(arr[2]);
        }
    }
    
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Deque<Log> stack = new LinkedList<>();
        for (String log : logs) {
            Log cur = new Log(log);
            if (cur.isStart) {
                stack.push(cur);
            } else {
                Log top = stack.pop();
                res[cur.id] += cur.ts - top.ts + 1;
                if (!stack.isEmpty()) {
                    res[stack.peek().id] -= cur.ts - top.ts + 1;
                }
            }
        }

        return res;
    }
}
// @lc code=end

