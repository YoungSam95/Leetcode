package leetcode;

/**
 * 796. 旋转字符串
 */

public class Solution796 {
    public static boolean rotateString(String s, String goal) {
        for(int i = 0; i < s.length() - 1; i++){
            s = s.substring(1,s.length()) + s.charAt(0);
            if(s.equals(goal)) return true;
        }
        return false;
    }
    public static void main(String[] args){
        String s = "abcde";
        String goal = "cdeab";
        System.out.println(rotateString(s,goal));
    }
}
