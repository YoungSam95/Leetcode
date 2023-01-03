package leetcode;

/**
 * 2042. 检查句子中的数字是否递增
 */
public class Solution2042 {
    public boolean areNumbersAscending(String s) {
        int num = -1;
        String[] tokens = s.split(" ");
        for(String token : tokens){
            if(Character.isDigit(token.charAt(0))){
                int temp = Integer.parseInt(token);
                if(temp <= num){
                    return false;
                }
                num = temp;
            }
        }
        return true;
    }
    public boolean areNumbersAscending2(String s) {
        int pre = 0, pos = 0;
        while (pos < s.length()) {
            if (Character.isDigit(s.charAt(pos))) {
                int cur = 0;
                while (pos < s.length() && Character.isDigit(s.charAt(pos))) {
                    cur = cur * 10 + s.charAt(pos) - '0';
                    pos++;
                }
                if (cur <= pre) {
                    return false;
                }
                pre = cur;
            } else {
                pos++;
            }
        }
        return true;
    }
}
