package leetcode;

/**
 * 1432. 改变一个整数能得到的最大差值
 */
public class Solution1432 {
    public int maxDiff(int num) {
        StringBuffer min_num = new StringBuffer(String.valueOf(num));
        StringBuffer max_num = new StringBuffer(String.valueOf(num));

        // 找到一个高位替换成 9
        int max_length = max_num.length();
        for (int i = 0; i < max_length; ++i) {
            char digit = max_num.charAt(i);
            if (digit != '9') {
                replace(max_num, digit, '9');
                break;
            }
        }

        // 将最高位替换成 1
        // 或者找到一个与最高位不相等的高位替换成 0
        int min_length = min_num.length();
        for (int i = 0; i < min_length; ++i) {
            char digit = min_num.charAt(i);
            if (i == 0) {
                if (digit != '1') {
                    replace(min_num, digit, '1');
                    break;
                }
            }
            else {
                if (digit != '0' && digit != min_num.charAt(0)) {
                    replace(min_num, digit, '0');
                    break;
                }
            }
        }

        return Integer.parseInt(max_num.toString()) - Integer.parseInt(min_num.toString());
    }

    public void replace(StringBuffer s, char x, char y) {
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            if (s.charAt(i) == x) {
                s.setCharAt(i, y);
            }
        }
    }
}
