import java.util.*;

/*
 * @lc app=leetcode id=1152 lang=java
 *
 * [1152] Analyze User Website Visit Pattern
 */

// @lc code=start
class Solution {
    class Visit implements Comparable<Visit> {
        String website;
        int ts;

        public Visit(String website, int ts) {
            this.website = website;
            this.ts = ts;
        }
        
        @Override
        public int compareTo(Visit o) {
            return this.ts - o.ts;
        }

        @Override
        public String toString() {
            return website + "-" + ts;
        }
        
    }
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        List<String> result = new ArrayList<>();
        Map<String, List<Visit>> map = new HashMap<>();
        Map<String, Set<String>> patterns = new HashMap<>();
        int n = username.length;
        int maxScore = 0;
        String maxPattern = null;
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(username[i], new ArrayList<>());
            map.get(username[i]).add(new Visit(website[i], timestamp[i]));
        }
        for (var entry : map.entrySet()) {
            Collections.sort(entry.getValue());
        }
        for (String user : map.keySet()) {
            List<Visit> visits = map.get(user);
            for (int i = 0; i < visits.size() - 2; i++) {
                for (int j = i + 1; j < visits.size() - 1; j++) {
                    for (int k = j + 1; k < visits.size(); k++) {
                        String pattern = visits.get(i).website + " " + visits.get(j).website + " " + visits.get(k).website;
                        patterns.putIfAbsent(pattern, new HashSet<>());
                        patterns.get(pattern).add(user);
                    }
                }
            }
        }
        for (var entry : patterns.entrySet()) {
            if (entry.getValue().size() > maxScore) {
                maxPattern = entry.getKey();
                maxScore = entry.getValue().size();
            } else if (entry.getValue().size() == maxScore && entry.getKey().compareTo(maxPattern) < 0) {
                maxPattern = entry.getKey();
            }
        }
        for (String web : maxPattern.split(" ")) {
            result.add(web);
        }

        return result;
    }
}
// @lc code=end

