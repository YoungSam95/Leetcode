package leetcode;

/**
 * 1415. 长度为 n 的开心字符串中字典序第 k 小的字符串
 */
public class Solution1415 {
    public String getHappyString(int n, int k) {
        char[] chs = {'a', 'b', 'c'};
        StringBuilder res = new StringBuilder();
        if (k > 3 * (1 << (n - 1))) {
            return res.toString();
        }
        for (int i = 0; i < n; i++) {
            int count = 1 << (n - i - 1);
            for (char c : chs) {
                if (res.length() > 0 && res.charAt(res.length() - 1) == c) {
                    continue;
                }
                if (k <= count) {
                    res.append(c);
                    break;
                }
                k -= count;
            }
        }
        return res.toString();
    }
}
