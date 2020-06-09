/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {
        int result = 0;
        if (s == "") {
            return result;
        }
        char[] digits = s.toCharArray();
        char pre = ' ';
        for (int i = 0; i < digits.length; i++) {
            switch(digits[i]) {
                case 'I':
                    result += 1;
                    pre = 'I';
                    break;
                case 'V':
                    if (pre == 'I') {
                        result -= 1;
                        result += 4;
                    } else {
                        result += 5;
                    }
                    pre = 'V';
                    break;
                case 'X':
                    if (pre == 'I') {
                        result -= 1;
                        result += 9;
                    } else {
                        result += 10;
                    }
                    pre = 'X';
                    break;
                case 'L':
                    if (pre == 'X') {
                        result -= 10;
                        result += 40;
                    } else {
                        result += 50;
                    }
                    pre = 'L';
                    break;
                case 'C':
                    if (pre == 'X') {
                        result -= 10;
                        result += 90;
                    } else {
                        result += 100;
                    }
                    pre = 'C';
                    break;
                case 'D':
                    if (pre == 'C') {
                        result -= 100;
                        result += 400;
                    } else {
                        result += 500;
                    }
                    pre = 'D';
                    break;
                case 'M':
                    if (pre == 'C') {
                        result -= 100;
                        result += 900;
                    } else {
                        result += 1000;
                    }
                    pre = 'M';
                    break;
                default:
                    break;
            }
        }
        return result;
    }
}
// @lc code=end

