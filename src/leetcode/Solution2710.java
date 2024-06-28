package leetcode;

/**
 * 2710. 移除字符串中的尾随零
 */
public class Solution2710 {
    public String removeTrailingZeros(String num) {
        int len = num.length();
        while (len > 0 && num.charAt(len - 1) == '0') {
            len--;
        }
        return num.substring(0, len);
    }
}
