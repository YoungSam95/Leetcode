package leetcode;

/**
 * 1784. 检查二进制字符串字段
 */
public class Solution1784 {
    public boolean checkOnesSegment(String s) {
        /*boolean flag = false;
        for(int i = 1; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '0') flag = true;
            if(flag && c == '1') return false;
        }
        return true;*/
        return !s.contains("01");
    }
}
