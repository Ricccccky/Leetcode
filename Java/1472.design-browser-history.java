import java.util.*;

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
        backUrl.push(homepage);
    }
    
    public void visit(String url) {
        forwardUrl.clear();
        backUrl.push(url);
    }
    
    public String back(int steps) {
        while (backUrl.size() > 1 && steps-- > 0) {
            forwardUrl.push(backUrl.pop());
        }

        return backUrl.peek();
    }
    
    public String forward(int steps) {
        while (!forwardUrl.isEmpty() && steps-- > 0) {
            backUrl.push(forwardUrl.pop());
        }

        return backUrl.peek();
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

