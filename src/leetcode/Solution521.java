package leetcode;

/**
 * 521. 最长特殊序列 Ⅰ
 */
public class Solution521 {
    public int findLUSlength(String a, String b) {
        return !a.equals(b) ? Math.max(a.length(), b.length()) : -1;
    }
}
