import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=1188 lang=java
 *
 * [1188] Design Bounded Blocking Queue
 */

// @lc code=start
class BoundedBlockingQueue {
    private Deque<Integer> queue;
    private int size;
    private Object lock;

    public BoundedBlockingQueue(int capacity) {
        queue = new LinkedList<>();
        lock = new Object();
        size = capacity;
    }
    
    public void enqueue(int element) throws InterruptedException {
        synchronized(lock) {
            while (queue.size() == size) {
                lock.wait();
            }
            queue.addLast(element);
            lock.notify();
        }
    }
    
    public int dequeue() throws InterruptedException {
        int val = 0;
        synchronized(lock) {
            while (queue.isEmpty()) {
                lock.wait();
            }
            val = queue.removeFirst();
            lock.notify();
        }

        return val;
    }
    
    public int size() {
        return queue.size();
    }
}
// @lc code=end

