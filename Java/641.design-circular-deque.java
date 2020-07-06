import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode id=641 lang=java
 *
 * [641] Design Circular Deque
 */

// @lc code=start
class MyCircularDeque {
    private List<Integer> deque;
    private int dequeSize;
    private int dequeLength;
    private int front;
    private int rear;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        deque = new ArrayList<>(Collections.nCopies(k, -1));
        dequeSize = k;
        dequeLength = 0;
        front = 0;
        rear = 0;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        } else if (isEmpty()) {
            deque.set(front, value);
        } else {
            front = front - 1;
            if (front < 0) {
                front = (front + dequeSize) % dequeSize;
            } else {
                front %= dequeSize;
            }
            deque.set(front, value);
        }
        dequeLength++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        } else if (isEmpty()) {
            deque.set(rear, value);
        } else {
            rear = (rear + 1) % dequeSize;
            deque.set(rear, value);
        }
        dequeLength++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        } else {
            deque.set(front, -1);
            front = (front + 1) % dequeSize;
            dequeLength--;
            if (isEmpty()) {
                front = rear;
            }
        }
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        } else {
            deque.set(rear, -1);
            rear = rear - 1;
            if (rear < 0) {
                rear = (rear + dequeSize) % dequeSize;
            } else {
                rear %= dequeSize;
            }
            dequeLength--;
            if (isEmpty()) {
                front = rear;
            }
        }
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        return deque.get(front);
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        return deque.get(rear);
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return dequeLength == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return dequeLength == dequeSize;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
// @lc code=end

