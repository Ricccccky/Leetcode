import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=716 lang=java
 *
 * [716] Max Stack
 */

// @lc code=start
class MaxStack {
    private Deque<Integer> stack;
    private Deque<Integer> maxStack;

    /** initialize your data structure here. */
    public MaxStack() {
        stack = new LinkedList<>();
        maxStack = new LinkedList<>();
    }
    
    public void push(int x) {
        int max = maxStack.isEmpty() ? x : maxStack.peek();
        maxStack.push(x > max ? x : max);
        stack.push(x);
    }
    
    public int pop() {
        maxStack.pop();
        return stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return maxStack.peek();
    }
    
    public int popMax() {
        Deque<Integer> tmp = new LinkedList<>();
        int max = maxStack.peek();
        while (top() != max) {
            tmp.push(pop());
        }
        pop();
        while (!tmp.isEmpty()) {
            push(tmp.pop());
        }

        return max;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
// @lc code=end

