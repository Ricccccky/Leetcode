/*
 * @lc app=leetcode id=1344 lang=java
 *
 * [1344] Angle Between Hands of a Clock
 */

// @lc code=start
class Solution {
    public double angleClock(int hour, int minutes) {
        int degreePerMin = 6, degreePerHour = 30;

        double minAngle = degreePerMin * minutes;
        double hourAngle = (hour + minutes / 60.0) * degreePerHour;
        double angle = Math.abs(minAngle - hourAngle);

        return Math.min(angle, 360 - angle);

    }
}
// @lc code=end

