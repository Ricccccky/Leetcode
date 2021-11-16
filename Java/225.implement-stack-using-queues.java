import java.util.*;

/*
 * @lc app=leetcode id=225 lang=java
 *
 * [225] Implement Stack using Queues
 */

// @lc code=start
class MyStack {
    private Queue<Integer> data;
    /** Initialize your data structure here. */
    public MyStack() {
        this.data = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        this.data.offer(x);
        for (int i = 0; i < this.data.size() - 1; i++) {
            this.data.offer(data.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return this.data.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return this.data.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return data.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

