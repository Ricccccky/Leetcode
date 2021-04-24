import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * @lc app=leetcode id=582 lang=java
 *
 * [582] Kill Process
 */

// @lc code=start
class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < pid.size(); i++) {
            int parent = ppid.get(i);
            int child = pid.get(i);
            map.putIfAbsent(parent, new ArrayList<>());
            map.get(parent).add(child);
        }
        queue.offer(kill);
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len-- > 0) {
                int node = queue.poll();
                res.add(node);
                if (map.containsKey(node)) {
                    for (int child : map.get(node)) {
                        queue.offer(child);
                    }
                }
            }
        }

        return res;
    }
}
// @lc code=end

