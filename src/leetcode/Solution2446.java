package leetcode;

/**
 * 2446. 判断两个事件是否存在冲突
 */
public class Solution2446 {
    public boolean haveConflict(String[] event1, String[] event2) {
        return !(event1[1].compareTo(event2[0]) < 0 || event2[1].compareTo(event1[0]) < 0);
    }
}
