package leetcode;

/**
 * 2864.最大二进制奇数
 */
public class Solution2864 {
    public String maximumOddBinaryNumber(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            cnt += s.charAt(i) - '0';
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cnt - 1; i++) {
            sb.append('1');
        }
        for (int i = 0; i < s.length() - cnt; i++) {
            sb.append('0');
        }
        sb.append('1');
        return sb.toString();
    }
}
