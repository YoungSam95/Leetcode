package leetcode;

/**
 * 3083. 字符串及其反转中是否存在同一子字符串
 */
public class Solution3083 {
    public boolean isSubstringPresent(String s) {
        for (int i = 0; i + 1 < s.length(); i++) {
            String substr = new StringBuilder(s.substring(i, i + 2)).reverse().toString();
            if (s.contains(substr)) {
                return true;
            }
        }
        return false;
    }
}
