package leetcode;

import java.util.Collections;
import java.util.List;

/**
 * 648. 单词替换
 */
public class Solution648 {
    public String replaceWords(List<String> dictionary, String sentence) {
        Collections.sort(dictionary);
        String[] words = sentence.split(" ");
        StringBuffer sb = new StringBuffer();
        for(String word : words){
            boolean flag = false;
            for(String root : dictionary){
                if(root.length() < word.length() && word.indexOf(root) == 0) {
                    sb.append(root).append(" ");
                    flag = true;
                    break;
                }
            }
            if(!flag){
                sb.append(word).append(" ");
            }
        }
        return sb.toString().trim();
    }
}
