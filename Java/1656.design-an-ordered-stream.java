import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=1656 lang=java
 *
 * [1656] Design an Ordered Stream
 */

// @lc code=start
class OrderedStream {
    String[] values;
    int ptr;

    public OrderedStream(int n) {
        values = new String[n];
        ptr = 0;
    }
    
    public List<String> insert(int idKey, String value) {
        List<String> result = new ArrayList<>();
        values[--idKey] = value;
        while (ptr < values.length && values[ptr] != null) {
            result.add(values[ptr]);
            ptr++;
        }

        return result;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */
// @lc code=end

