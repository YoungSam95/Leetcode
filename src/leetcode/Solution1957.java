package leetcode;

/**
 * 1957. 删除字符使字符串变好
 */
public class Solution1957 {
    public String makeFancyString(String s) {
        StringBuilder res = new StringBuilder();   // 删除后的字符串
        // 遍历 s 模拟删除过程
        for (char ch : s.toCharArray()) {
            int n = res.length();
            if (n >= 2 && res.charAt(n - 1) == ch && res.charAt(n - 2) == ch) {
                // 如果 res 最后两个字符与当前字符均相等，则不添加
                continue;
            }
            // 反之则添加
            res.append(ch);
        }
        return res.toString();
    }
}
