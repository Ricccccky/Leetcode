import java.util.Stack;

/*
 * @lc app=leetcode id=901 lang=java
 *
 * [901] Online Stock Span
 */

// @lc code=start
class StockSpanner {

    private Stack<int[]> prices;
    public StockSpanner() {
        prices = new Stack<>();
    }
    
    public int next(int price) {
        int[] temp = new int[] {price, 1};
        while (!prices.isEmpty() && prices.peek()[0] <= price) {
            temp[1] += prices.pop()[1];
        }
        prices.push(temp);
        return temp[1];
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
// @lc code=end

