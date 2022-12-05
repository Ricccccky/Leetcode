/*
 * @lc app=leetcode id=331 lang=java
 *
 * [331] Verify Preorder Serialization of a Binary Tree
 */

// @lc code=start
class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] arr = preorder.split(",");
        int space = 1;
        for (String node : arr) {
            space--;
            if (space < 0) {
                return false;
            }
            if (!node.equals("#")) {
                space += 2;
            }
        }

        return space == 0;
    }
}
// @lc code=end

