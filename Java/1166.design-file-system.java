import java.util.*;

/*
 * @lc app=leetcode id=1166 lang=java
 *
 * [1166] Design File System
 */

// @lc code=start
class FileSystem {
    private Map<String, Integer> paths;
    public FileSystem() {
        paths = new HashMap<>();
    }
    
    public boolean createPath(String path, int value) {
        if (paths.containsKey(path)) {
            return false;
        }
        int dirIdx = path.lastIndexOf("/");
        String dir = path.substring(0, dirIdx);
        if (dir.length() > 1 && !paths.containsKey(dir)) {
            return false;
        }
        paths.put(path, value);

        return true;
    }
    
    public int get(String path) {
        return paths.getOrDefault(path, -1);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */
// @lc code=end

