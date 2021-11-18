import java.util.*;

/*
 * @lc app=leetcode id=777 lang=java
 *
 * [777] Swap Adjacent in LR String
 */

// @lc code=start
class Solution {
    class Pair {
        int idx;
        char c;

        public Pair(char c, int idx) {
            this.c = c;
            this.idx = idx;
        }
    }

    public boolean canTransform(String start, String end) {
        List<Pair> l1 = new ArrayList<>();
        List<Pair> l2 = new ArrayList<>();
        int n = start.length();
        for (int i = 0; i < n; i++) {
            char sc = start.charAt(i);
            char ec = end.charAt(i);
            if (sc == 'L' || sc == 'R') {
                l1.add(new Pair(sc, i));
            }
            if (ec == 'L' || ec == 'R') {
                l2.add(new Pair(ec, i));
            }
        }
        if (l1.size() != l2.size()) {
            return false;
        }
        for (int i = 0; i < l1.size(); i++) {
            Pair p1 = l1.get(i);
            Pair p2 = l2.get(i);
            if (p1.c != p2.c) {
                return false;
            }
            if (p1.c == 'L') {
                if (p1.idx < p2.idx) {
                    return false;
                }
            } else {
                if (p1.idx > p2.idx) {
                    return false;
                }
            }
        }

        return true;
    }
}
// @lc code=end

