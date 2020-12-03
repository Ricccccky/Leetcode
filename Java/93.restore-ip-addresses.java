import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=93 lang=java
 *
 * [93] Restore IP Addresses
 */

// @lc code=start
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() > 12) {
            return result;
        }
        dfs(result, s, 0, 0, "");
        return result;
    }

    private void dfs(List<String> list, String s, int pos, int count, String ip) {
        if (count == 4 && pos == s.length()) {
            list.add(ip);
            return;
        }
        for (int i = 1; i < 4; i++) {
            if (pos + i > s.length()) {
                break;
            }
            String section = s.substring(pos, pos + i);
            if (section.startsWith("0") && section.length() > 1|| Integer.valueOf(section) > 255) {
                break;
            }
            if (count == 0) {
                dfs(list, s, pos + i, count + 1, section);
            } else {
                dfs(list, s, pos + i, count + 1, ip + "."+ section);
            }
        }
    }
}
// @lc code=end

