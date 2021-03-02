import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution151 {

    public static String reverseWords(String s) {

        String trimed = s.trim();//去掉s的首尾空格

        String[] split = trimed.split("\\s+");//将s以空格分开

        StringBuilder builder = new StringBuilder();
        for(int i = split.length-1;i >= 0;i--){
            String t = split[i];
//            if(t.trim().isEmpty()){//碰到空格后continue，不写到builder中
//                continue;
//            }
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
