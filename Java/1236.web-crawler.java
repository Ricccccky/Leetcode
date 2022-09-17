import java.util.*;

/*
 * @lc app=leetcode id=1236 lang=java
 *
 * [1236] Web Crawler
 */

// @lc code=start
/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */

class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        Deque<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        String hostname = startUrl.split("/")[2];
        visited.add(startUrl);
        queue.offer(startUrl);
        while (!queue.isEmpty()) {
            String root = queue.poll();
            for (String url : htmlParser.getUrls(root)) {
                if (url.contains(hostname) && !visited.contains(url)) {
                    queue.offer(url);
                    visited.add(url);
                }
            }
        }

        return new ArrayList<>(visited);
    }
}
// @lc code=end

