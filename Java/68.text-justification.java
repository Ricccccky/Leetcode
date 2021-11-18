import java.util.*;

/*
 * @lc app=leetcode id=68 lang=java
 *
 * [68] Text Justification
 */

// @lc code=start
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int size = words[0].length();
        for (int i = 1; i <= words.length; i++) {
            if (i == words.length) {
                map.put(i - 1, size);
            } else {
                if (size + words[i].length() + 1 > maxWidth) {
                    map.put(i - 1, size);
                    size = words[i].length();
                } else {
                    size += words[i].length() + 1;
                }
            }
        }
        List<Integer> keys = new ArrayList<>(map.keySet());
        keys.add(0, -1);
        Collections.sort(keys);
        for (int i = 1; i < keys.size(); i++) {
            StringBuilder sb = new StringBuilder();
            int start = keys.get(i - 1) + 1;
            int end = keys.get(i);
            int num = end - start;
            int space = maxWidth - map.get(keys.get(i));
            if (i == keys.size() - 1 || num == 0) {
                for (int j = 0; j <= num; j++) {
                    sb.append(words[start + j]);
                    if (j < num) {
                        sb.append(" ");
                    }
                }
                fillSpace(sb, space);
            } else if (space % num == 0) {
                int div = space / num;
                for (int j = 0; j <= num; j++) {
                    sb.append(words[start + j]);
                    if (j < num) {
                        fillSpace(sb, div + 1);
                    }
                }
            } else {
                int div = space / num;
                int rem = space % num;
                for (int j = 0; j <= num; j++) {
                    sb.append(words[start + j]);
                    if (j < num) {
                        if (j < rem) {
                            fillSpace(sb, div + 2);
                        } else {
                            fillSpace(sb, div + 1);
                        }
                    }
                }
            }
            res.add(sb.toString());
        }

        return res;
    }

    private void fillSpace(StringBuilder sb, int num) {
        for (int i = 0; i < num; i++) {
            sb.append(" ");
        }
    }
}
// @lc code=end

