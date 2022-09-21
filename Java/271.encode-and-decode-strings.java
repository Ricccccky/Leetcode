import java.util.*;

/*
 * @lc app=leetcode id=271 lang=java
 *
 * [271] Encode and Decode Strings
 */

// @lc code=start
public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();
        for (String str : strs) {
            sb.append(str.replace("#", "##"))
            .append(" # ");
        }

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        String[] strs = s.split(" # ", -1);
        for (int i = 0; i < strs.length - 1; i++) {
            result.add(strs[i].replace("##", "#"));
        }

        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
// @lc code=end

