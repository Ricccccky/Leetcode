import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

// @lc code=start
class MinStack {
    private Deque<int[]> stack;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
    }
    
    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new int[] {val, val});
        } else {
            stack.push(new int[] {val, Math.min(val, stack.peek()[1])});
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

