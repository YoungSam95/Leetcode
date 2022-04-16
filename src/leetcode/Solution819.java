package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution819 {

    public static String mostCommonWord(String paragraph, String[] banned) {
        Set<String> banneds = new HashSet<>();
        Map<String,Integer> map = new HashMap<>();
        for(String str : banned){
            banneds.add(str);
        }
        int max = 0;
        StringBuilder sb = new StringBuilder();
        for(int index = 0; index <= paragraph.length(); index++){
            if(index < paragraph.length() && Character.isLetter(paragraph.charAt(index))){
                sb.append(paragraph.charAt(index));
            }else if(sb.length() > 0){
                String word = sb.toString().toLowerCase();
                if(!banneds.contains(word)) {
                    int frequency = map.getOrDefault(word,0) + 1;
                    map.put(word,frequency);
                    max = Math.max(max,frequency);
                }
                sb.setLength(0);
            }
        }
        String res = "";
        for(String word : map.keySet()){
            int frequency = map.get(word);
            if(frequency == max){
                res = word;
                break;
            }
        }
        return res;
    }
    public static void main(String[] args){
        String[] banned = {"aob"};
        System.out.println(mostCommonWord("Bob",banned));
    }
}
