package leetcode;

/**
 * 2810. 故障键盘
 */
public class Solution2810 {
    public String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) == 'i'){
                sb.reverse();
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
