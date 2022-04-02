package leetcode;

/**
 * 58. 最后一个单词的长度
 */

public class Solution58 {

    public static int lengthOfLastWord(String s) {
        int count = 0;
        int index = s.length() - 1;
        while(s.charAt(index) == ' '){
            index--;
        }
        while(index >= 0 && s.charAt(index) != ' '){
            count++;
            index--;
        }
        return count;
    }
    public static void main(String[] args){
        String s = "   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord(s));
    }
}
