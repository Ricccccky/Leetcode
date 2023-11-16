import java.util.*;

/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        // ascending stack
        Deque<Integer> stack = new LinkedList<>();
        int i = 0, result = 0, n = heights.length;
        while (i < n) {
            if (stack.isEmpty()) {
                stack.push(i);
                i++;
            } else {
                if (heights[i] >= heights[stack.peek()]) {
                    stack.push(i);
                    i++;
                } else {
                    int top = stack.pop();
                    if (stack.isEmpty()) {
                        result = Math.max(result, heights[top] * i);
                    } else {
                        result = Math.max(result, heights[top] * (i - 1 - stack.peek()));
                    }
                }
            }
        }

        while (!stack.isEmpty()) {
            int top = stack.pop();
            if (stack.isEmpty()) {
                result = Math.max(result, heights[top] * i);
            } else {
                result = Math.max(result, heights[top] * (i - 1 - stack.peek()));
            }
        }

        return result;
    }
}
// @lc code=end

