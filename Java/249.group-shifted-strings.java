/*
 * @lc app=leetcode id=249 lang=java
 *
 * [249] Group Shifted Strings
 */

// @lc code=start
class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String string : strings) {
            int offset = string.charAt(0) - 'a';
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < string.length(); i++) {
                char c = string.charAt(i);
                int shift = (c - offset - 'a' + 26) % 26;
                char tmp = (char)(shift + 'a');
                sb.append(tmp);
            }
            map.putIfAbsent(sb.toString(), new ArrayList<>());
            map.get(sb.toString()).add(string);
        }
        
        return new ArrayList<>(map.values());
    }
}
// @lc code=end

