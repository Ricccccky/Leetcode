/*
 * @lc app=leetcode id=251 lang=java
 *
 * [251] Flatten 2D Vector
 */

// @lc code=start
class Vector2D {
    private int i;
    private int j;
    private int[][] arr;

    public Vector2D(int[][] vec) {
        i = 0;
        j = 0;
        arr = vec;
    }
    
    public int next() {
        if (hasNext()) {
            return arr[i][j++];
        }

        return -501;
    }
    
    public boolean hasNext() {
        while (i < arr.length && j == arr[i].length) {
            i++;
            j = 0;
        }
        
        return i != arr.length;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// @lc code=end

