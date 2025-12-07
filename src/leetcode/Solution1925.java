package leetcode;

/**
 * 1925. 统计平方和三元组的数目
 */
public class Solution1925 {
    public int countTriples(int n) {
        int res = 0;
        // 枚举 a 与 b
        for (int a = 1; a <= n; ++a) {
            for (int b = 1; b <= n; ++b) {
                // 判断是否符合要求
                int c = (int) Math.sqrt(a * a + b * b + 1.0);
                if (c <= n && c * c == a * a + b * b) {
                    ++res;
                }
            }
        }
        return res;
    }
}
