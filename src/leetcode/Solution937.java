package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 937. 重新排列日志文件
 */

public class Solution937 {
    public String[] reorderLogFiles(String[] logs) {
        List<String> digit = new ArrayList<>();
        List<String> letter = new ArrayList<>();
        for(String log : logs){
            if(Character.isDigit(log.split(" ")[1].charAt(0))){
                digit.add(log);
            }else{
                letter.add(log);
            }
        }
        Collections.sort(letter, (str1, str2) -> {
            String[] log1 = str1.split(" ",2);
            String[] log2 = str2.split(" ",2);
            if(log1[1].equals(log2[1])){
                return log1[0].compareTo(log2[0]);
            }else{
                return log1[1].compareTo(log2[1]);
            }
        });
        String[] res = new String[letter.size() + digit.size()];
        int index = 0;
        for(int i = 0; i < letter.size(); i++){
            res[index++] = letter.get(i);
        }
        for(int i = 0; i < digit.size(); i++){
            res[index++] = digit.get(i);
        }
        return res;
    }
    public static void main(String[] args){
        String s = "a  b";
        for(String str : s.split(" ")) {
            System.out.println(str);
        }
    }
}
