import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=1472 lang=java
 *
 * [1472] Design Browser History
 */

// @lc code=start
class BrowserHistory {
    Deque<String> backUrl;
    Deque<String> forwardUrl;
    public BrowserHistory(String homepage) {
        backUrl = new LinkedList<>();
        forwardUrl = new LinkedList<>();
        backUrl.addFirst(homepage);
    }
    
    public void visit(String url) {
        forwardUrl.clear();
        backUrl.addFirst(url);
    }
    
    public String back(int steps) {
        while (backUrl.size() > 1 && steps-- > 0) {
            forwardUrl.addFirst(backUrl.removeFirst());
        }

        return backUrl.peekFirst();
    }
    
    public String forward(int steps) {
        while (!forwardUrl.isEmpty() && steps-- > 0) {
            backUrl.addFirst(forwardUrl.removeFirst());
        }

        return backUrl.peekFirst();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
// @lc code=end

