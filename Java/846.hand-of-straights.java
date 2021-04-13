import java.util.Map;
import java.util.TreeMap;

/*
 * @lc app=leetcode id=846 lang=java
 *
 * [846] Hand of Straights
 */

// @lc code=start
class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            if (count == 0) {
                continue;
            }
            for (int i = entry.getKey(); i < entry.getKey() + W; i++) {
                if (!map.containsKey(i) || map.get(i) < count) {
                    return false;
                }
                map.put(i, map.get(i) - count);
            }
        }

        return true;
    }
}
// @lc code=end

