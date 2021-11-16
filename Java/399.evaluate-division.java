import java.util.*;

/*
 * @lc app=leetcode id=399 lang=java
 *
 * [399] Evaluate Division
 */

// @lc code=start
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        double[] res = new double[queries.size()];
        int n = equations.size();
        for (int i = 0; i < n; i++) {
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);
            map.putIfAbsent(dividend, new HashMap<>());
            map.putIfAbsent(divisor, new HashMap<>());
            map.get(dividend).put(divisor, values[i]);
            map.get(divisor).put(dividend, 1 / values[i]);
        }
        for (int i = 0; i < res.length; i++) {
            String dividend = queries.get(i).get(0);
            String divisor = queries.get(i).get(1);
            if (!map.containsKey(dividend) || !map.containsKey(divisor)) {
                res[i] = -1.0;
            } else {
                res[i] = Math.max(-1.0, dfs(map, dividend, divisor, new HashSet<>()));
            }
        }

        return res;
    }

    private double dfs(Map<String, Map<String, Double>> map, String dividend, String divisor, Set<String> visited) {
        if (dividend.equals(divisor)) {
            return 1.0;
        }
        double res = -1.0;
        visited.add(dividend);
        for (Map.Entry<String, Double> neighbor : map.get(dividend).entrySet()) {
            if (!visited.contains(neighbor.getKey())) {
                double cur = dfs(map, neighbor.getKey(), divisor, visited);
                if (cur > 0) {
                    res = cur * neighbor.getValue();
                    break;
                }
            }
        }
        visited.remove(dividend);

        return res;
    }
}
// @lc code=end

