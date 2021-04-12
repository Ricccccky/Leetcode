import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=166 lang=java
 *
 * [166] Fraction to Recurring Decimal
 */

// @lc code=start
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        Map<Long, Integer> map = new HashMap<>();
        if (numerator < 0 ^ denominator < 0) {
            res.append("-");
        }
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        long reminder = dividend % divisor;
        res.append(String.valueOf(dividend / divisor));
        if (reminder == 0) {
            return res.toString();
        }
        res.append(".");
        while (reminder != 0) {
            if (map.containsKey(reminder)) {
                res.insert(map.get(reminder), "(");
                res.append(")");
                break;
            }
            map.put(reminder, res.length());
            reminder *= 10;
            dividend = reminder;
            while (dividend < divisor) {
                dividend *= 10;
                res.append("0");
            }
            res.append(String.valueOf(dividend / divisor));
            reminder = dividend % divisor;

        }
        
        return res.toString();
    }
}
// @lc code=end

