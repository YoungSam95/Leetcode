package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 953. 验证外星语词典
 */

public class Solution953 {
    public static boolean isAlienSorted(String[] words, String order) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < order.length(); i++){
            map.put(order.charAt(i),i);
        }
        for(int i = 0; i < words.length - 1; i++){
            for(int j = 0; j < words[i].length(); j++){
                if(j == words[i + 1].length()) return false;
                if(map.get(words[i].charAt(j)) < map.get(words[i + 1].charAt(j))){
                    break;
                }else if(map.get(words[i].charAt(j)) == map.get(words[i + 1].charAt(j))){
                    continue;
                }else if(map.get(words[i].charAt(j)) > map.get(words[i + 1].charAt(j))){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args){
        String[] words = {"ab","ab","ab"};
        String order = "worldabcefghijkmnpqstuvxyz";
        System.out.println(isAlienSorted(words,order));
    }
}
