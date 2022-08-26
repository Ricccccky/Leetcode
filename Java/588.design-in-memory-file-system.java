import java.util.*;

/*
 * @lc app=leetcode id=588 lang=java
 *
 * [588] Design In-Memory File System
 */

// @lc code=start
class FileSystem {

    File root;
    public FileSystem() {
        root = new File("");
    }
    
    public List<String> ls(String path) {
        return parserPath(path).getList();
    }
    
    public void mkdir(String path) {
        parserPath(path);
    }
    
    public void addContentToFile(String filePath, String content) {
        parserPath(filePath).addContent(content);
    }
    
    public String readContentFromFile(String filePath) {
        return parserPath(filePath).getContent();
    }

    private File parserPath(String path) {
        String[] files = path.split("/");
        File dummy = root;
        for (String dir : files) {
            if (dir.length() == 0) {
                continue;
            }
            dummy.child.putIfAbsent(dir, new File(dir));
            dummy = dummy.child.get(dir);
            if (dummy.isFile()) {
                break;
            }
        }

        return dummy;
    }

    private class File {
        private TreeMap<String, File> child;
        private String name;
        private StringBuilder content;

        public File(String name) {
            this.name = name;
            content = new StringBuilder();
            child = new TreeMap<>();
        }

        public String getContent() {
            return content.toString();
        }

        public String getName() {
            return name;
        }

        public boolean isFile() {
            return content.length() > 0;
        }

        public void addContent(String s) {
            content.append(s);
        }

        public List<String> getList() {
            List<String> result = new ArrayList<>();
            if (isFile()) {
                result.add(name);
            } else {
                for (var entry : child.entrySet()) {
                    result.add(entry.getValue().name);
                }
            }

            return result;
        }
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
// @lc code=end

