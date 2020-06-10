import java.util.Stack;

/*
 * @lc app=leetcode id=71 lang=java
 *
 * [71] Simplify Path
 */

// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        if (path.length() == 0) {
            return null;
        }
        String result = "";
        String[] pathArray = path.split("/");
        Stack<String> temp = new Stack<>();
        Stack<String> stack = new Stack<>();
        for (String dir : pathArray) {
            if (dir.equals(".") || dir.equals("")) {
                continue;
            } else if (dir.equals("..")) {
                if (!temp.isEmpty()) {
                    temp.pop();
                }
            } else {
                temp.push(dir);
            }
        }
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
        while (!stack.isEmpty()) {
            result += "/" + stack.pop();
        }
        if (result.equals("")) {
            result += "/";
        }
        return result;
    }
}
// @lc code=end

