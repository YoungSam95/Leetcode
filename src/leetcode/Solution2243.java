package leetcode;

/**
 * 2243. 计算字符串的数字和
 */
public class Solution2243 {
    public String digitSum(String s, int k) {
        while (s.length() > k) {
            StringBuilder tmp = new StringBuilder();   // 每次操作结束的字符串
            int n = s.length();
            for (int i = 0; i < n; i += k) {
                int val = 0;
                for (int j = i; j < Math.min(i + k, n); ++j) {
                    val += s.charAt(j) - '0';
                }
                tmp.append(val);
            }
            s = tmp.toString();
        }
        return s;
    }
}
