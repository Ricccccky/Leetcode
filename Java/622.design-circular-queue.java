import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode id=622 lang=java
 *
 * [622] Design Circular Queue
 */

// @lc code=start
class MyCircularQueue {

    private List<Integer> queue;
    private int queueSize;
    private int queueLength;
    private int head;
    private int tail;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        queue = new ArrayList<>(Collections.nCopies(k, -1));
        queueSize = k;
        queueLength = 0;
        head = 0;
        tail = 0;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        } else if (isEmpty()) {
            queue.set(tail, value);
        } else {
            tail = (tail + 1) % queueSize;
            queue.set(tail, value);
        }
        queueLength++;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        } else {
            queue.set(head, -1);
            head = (head + 1) % queueSize;
        }
        queueLength--;
        if (queueLength == 0) {
            head = 0;
            tail = 0;
        }
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        return queue.get(head);
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        return queue.get(tail);
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return queueLength == 0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return queueLength == queueSize;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
// @lc code=end

