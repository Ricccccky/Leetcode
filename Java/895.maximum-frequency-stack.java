import java.util.*;

/*
 * @lc app=leetcode id=895 lang=java
 *
 * [895] Maximum Frequency Stack
 */

// @lc code=start
class FreqStack {
    class Elem implements Comparable<Elem> {
        public int val;
        public int ts;
        public int freq;

        public Elem(int val, int ts, int freq) {
            this.val = val;
            this.ts = ts;
            this.freq = freq;
        }

        @Override
        public int compareTo(Elem o) {
            if (this.freq == o.freq) {
                return o.ts - this.ts;
            } else {
                return o.freq - this.freq;
            }
        }
        @Override
        public String toString() {
            return val + ", " + ts + ", " + freq;
        }
    }

    Map<Integer, Elem> map;
    PriorityQueue<Elem> stack;
    private int time;

    public FreqStack() {
        map = new HashMap<>();
        stack = new PriorityQueue<>();
        time = 0;
    }
    
    public void push(int val) {
        int freq = 1;
        if (map.containsKey(val)) {
            freq += map.get(val).freq;
        }
        map.put(val, new Elem(val, time, freq));
        stack.offer(new Elem(val, time, freq));
        time++;
    }
    
    public int pop() {
        Elem e = stack.poll();
        map.get(e.val).freq--;
        return e.val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
// @lc code=end

