package leetcode; /**
 *151. 翻转字符串里的单词
 * 无空格字符构成一个 单词 。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution151 {

    public static String reverseWords(String s) {

        String trimed = s.trim();//去掉s的首尾空格

        String[] split = trimed.split("\\s+");//将s以空格分开 \\s+为多个空格的正则表达式
        StringBuilder builder = new StringBuilder();

        for(int i = split.length-1;i >= 0;i--){
            String t = split[i];
            builder.append(t).append(" ");
        }

        return builder.toString().trim();

        /*//除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);*/

    }

    public static void main(String[] args){
        String s = "  Bob    Loves  Alice   ";
        System.out.println(reverseWords(s));
    }
}
