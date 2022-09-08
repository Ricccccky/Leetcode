/*
 * @lc app=leetcode id=2288 lang=java
 *
 * [2288] Apply Discount to Prices
 */

// @lc code=start
class Solution {
    public String discountPrices(String sentence, int discount) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            long price = isPrice(words[i]);
            if (price > 0) {
                double newPrice = (double)price - price * discount / 100.0;
                words[i] = String.format("$%.2f", newPrice);
            }
        }

        return String.join(" ", words);
    }

    private long isPrice(String word) {
        long result = -1;
        if (word.charAt(0) != '$') {
            return -1;
        }
        String price = word.substring(1);
        try {
            result = Long.parseLong(price);
        } catch (Exception e) {
            return -1;
        }

        return result;
    }
}
// @lc code=end

