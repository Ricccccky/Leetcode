import java.util.*;

/*
 * @lc app=leetcode id=722 lang=java
 *
 * [722] Remove Comments
 */

// @lc code=start
class Solution {
    public List<String> removeComments(String[] source) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean state = false;
        for (String line : source) {
            int n = line.length();
            for (int i = 0; i < n; i++) {
                if (state) {
                    if (line.charAt(i) == '*' && i < n - 1 && line.charAt(i + 1) == '/') {
                        state = false;
                        // skip next "/"
                        i++;
                    }
                } else {
                    if (line.charAt(i) == '/' && i < n - 1 && line.charAt(i + 1) == '/') {
                        break;
                    } else if (line.charAt(i) == '/' && i < n - 1 && line.charAt(i + 1) == '*') {
                        state = true;
                        // skip next "*"
                        i++;
                    } else {
                        sb.append(line.charAt(i));
                    }
                }
            }
            if (!state && sb.length() > 0) {
                result.add(sb.toString());
                sb = new StringBuilder();
            }
        }

        return result;
    }
}
// @lc code=end

