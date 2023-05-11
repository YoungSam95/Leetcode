package leetcode;

/**
 * 1016. 子串能表示从 1 到 N 数字的二进制串
 */
public class Solution1016 {
    public boolean queryString(String s, int n) {
        for(int i = 1; i <= n; i++) {
            if(!s.contains(Integer.toBinaryString(i))) {
                return false;
            }
        }
        return true;
    }
}
