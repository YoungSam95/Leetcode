package leetcode;

/**
 * 1003. 检查替换后的词是否有效
 */
public class Solution1003 {
    public boolean isValid(String s) {
        StringBuilder stk = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stk.append(c);
            if (stk.length() >= 3 && stk.substring(stk.length() - 3).equals("abc")) {
                stk.delete(stk.length() - 3, stk.length());
            }
        }
        return stk.length() == 0;
    }
}
