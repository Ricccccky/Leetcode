/*
 * @lc app=leetcode id=273 lang=java
 *
 * [273] Integer to English Words
 */

// @lc code=start
class Solution {
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();
        int billion = num / (int)1e9;
        num %= (int)1e9;
        int million = num / (int)1e6;
        num %= (int)1e6;
        int thousand = num / (int)1e3;
        num %= (1e3);
        if (billion != 0) {
            sb.append(threeDigits(billion))
            .append(" Billion ");
        }
        if (million != 0) {
            sb.append(threeDigits(million))
            .append(" Million ");
        }
        if (thousand != 0) {
            sb.append(threeDigits(thousand))
            .append(" Thousand ");
        }
        if (num != 0) {
            sb.append(threeDigits(num));
        }

        return sb.toString().trim();
    }

    private String threeDigits(int num) {
        StringBuilder sb = new StringBuilder();
        int hundred = num / 100;
        int rest = num % 100;
        if (hundred != 0) {
            sb.append(wordMap(hundred))
            .append(" Hundred");
        }
        if (rest >= 20) {
            sb.append(" ")
            .append(wordMap(rest / 10 * 10))
            .append(" ")
            .append(wordMap(rest % 10));
        } else {
            sb.append(" ")
            .append(wordMap(rest));
        }

        return sb.toString().trim();
    }

    private String wordMap(int num) {
        switch (num) {
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
            case 10: return "Ten";
            case 11: return "Eleven";
            case 12: return "Twelve";
            case 13: return "Thirteen";
            case 14: return "Fourteen";
            case 15: return "Fifteen";
            case 16: return "Sixteen";
            case 17: return "Seventeen";
            case 18: return "Eighteen";
            case 19: return "Nineteen";
            case 20: return "Twenty";
            case 30: return "Thirty";
            case 40: return "Forty";
            case 50: return "Fifty";
            case 60: return "Sixty";
            case 70: return "Seventy";
            case 80: return "Eighty";
            case 90: return "Ninety";
            default: return "";
        }
    }
}
// @lc code=end

