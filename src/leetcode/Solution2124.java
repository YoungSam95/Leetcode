package leetcode;

/**
 * 2124. 检查是否所有 A 都在 B 之前
 */
public class Solution2124 {
    public boolean checkString(String s) {
        return !s.contains("ba");
    }
}
