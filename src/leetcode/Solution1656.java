package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1656. 设计有序流
 * 第二次
 */
public class Solution1656 {
    class OrderedStream {

        private String[] values;
        private int ptr;

        public OrderedStream(int n) {
            values = new String[n + 1];
            ptr = 1;
        }

        public List<String> insert(int idKey, String value) {
            values[idKey] = value;
            List<String> list = new ArrayList<>();
            if(idKey == ptr) {
                for (; ptr < values.length; ptr++) {
                    if (values[ptr] != null) {
                        list.add(values[ptr]);
                    } else {
                        break;
                    }
                }
            }
            return list;
        }
    }
}
