package leetcode;

/**
 * 3340. 检查平衡字符串
 */
public class Solution3340 {
    public boolean isBalanced(String num) {
        int diff = 0, sign = 1;
        for (int i = 0; i < num.length(); ++i) {
            int d = num.charAt(i) - '0';
            diff += d * sign;
            sign = -sign;
        }
        return diff == 0;
    }
}
