import java.util.*;

/*
 * @lc app=leetcode id=1381 lang=java
 *
 * [1381] Design a Stack With Increment Operation
 */

// @lc code=start
class CustomStack {
    private Deque<Integer> stack;
    int capacity;
    int[] inc;
    public CustomStack(int maxSize) {
        stack = new LinkedList<>();
        capacity = maxSize;
        inc = new int[capacity];
    }
    
    public void push(int x) {
        if (stack.size() < capacity) {
            stack.push(x);
        }
    }
    
    public int pop() {
        int i = stack.size() - 1;
        if (i < 0) {
            return -1;
        }
        if (i > 0) {
            inc[i - 1] += inc[i];
        }
        int result = stack.pop() + inc[i];
        inc[i] = 0;

        return result;
    }
    
    public void increment(int k, int val) {
        int i = Math.min(stack.size(), k) - 1;
        if (i >= 0) {
            inc[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
// @lc code=end

