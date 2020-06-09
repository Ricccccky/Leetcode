import java.util.Stack;

/*
 * @lc app=leetcode id=232 lang=java
 *
 * [232] Implement Queue using Stacks
 */

// @lc code=start
class MyQueue {
    private Stack<Integer> data;
    /** Initialize your data structure here. */
    public MyQueue() {
        this.data = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        // this.data.push(x);
        Stack<Integer> temp = new Stack<>();
        while (!this.data.isEmpty()) {
            temp.push(this.data.pop());
        }
        temp.push(x);
        while (!temp.isEmpty()) {
            this.data.push(temp.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return this.data.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return this.data.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return this.data.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

