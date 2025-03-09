package leetcode;

/**
 * 2269. 找到一个数字的 K 美丽值
 */
public class Solution2269 {
    public int divisorSubstrings(int num, int k) {
        String s = Integer.toString(num);   // num 十进制表示字符串
        int n = s.length();
        int res = 0;
        for (int i = 0; i <= n - k; ++i) {
            // 枚举所有长度为 k 的子串
            int tmp = Integer.parseInt(s.substring(i, i + k));
            if (tmp != 0 && num % tmp == 0) {
                ++res;
            }
        }
        return res;
    }
}
