import java.util.Arrays;

/*
 * @lc app=leetcode id=881 lang=java
 *
 * [881] Boats to Save People
 */

// @lc code=start
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int result = 0;
        int n = people.length;
        int l = 0, r = n - 1;
        Arrays.sort(people);
        while (l <= r) {
            if (people[l] + people[r] > limit) {
                r--;
            } else {
                l++;
                r--;
            }
            result++;
        }

        return result;
    }
}
// @lc code=end

