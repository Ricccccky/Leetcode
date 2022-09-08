/*
 * @lc app=leetcode id=1360 lang=java
 *
 * [1360] Number of Days Between Two Dates
 */

// @lc code=start
class Solution {
    static int monthDays[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(day2date(date2) - day2date(date1));
    }

    private int day2date(String date) {
        int result = 0;
        String[] arr = date.split("-");
        int year = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        int day = Integer.parseInt(arr[2]);
        for (int i = 1971; i < year; i++) {
            if ((i % 100 == 0 && i % 400 == 0) || (i % 100 != 0 && i % 4 == 0)) {
                result += 366;
            } else {
                result += 365;
            }
        }
        for (int i = 0; i < month - 1; i++) {
            result += monthDays[i];
            if (i == 1 && ((year % 100 == 0 && year % 400 == 0) || (year % 100 != 0 && year % 4 == 0))) {
                result++;
            }
        }
        result += day;

        return result;
    }
}
// @lc code=end

