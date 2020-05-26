import java.util.Stack;

/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> temp = new Stack<>();
        int i = 0;
        int result = 0;
        int top;
        while (i < heights.length) {
            if (temp.isEmpty()) {
                temp.push(i);
                i++;
            } else {
                if (heights[i] >= heights[temp.peek()]) {
                    temp.push(i);
                    i++;
                } else {
                    top = temp.pop();
                    if (temp.isEmpty()) {
                        result = Math.max(result, heights[top] * i);
                    } else {
                        result = Math.max(result, heights[top] * (i - 1 - temp.peek()));
                    }
                }
            }
        }

        while (!temp.isEmpty()) {
            top = temp.pop();
            if (temp.isEmpty()) {
                result = Math.max(result, heights[top] * i);
            } else {
                result = Math.max(result, heights[top] * (i - 1 - temp.peek()));
            }
        }
        return result;
    }
}
// @lc code=end

