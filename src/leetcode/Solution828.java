package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 828. 统计子串中的唯一字符
 */
public class Solution828 {
    public int uniqueLetterString(String s) {
        Map<String,Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = 1; i + j <= s.length(); j++){
                String sub = s.substring(i,i + j);
                if(map.containsKey(sub)){
                    res += map.get(sub);
                }else{
                    int temp = countUniqueChars(sub);
                    res += temp;
                    map.put(sub,temp);
                }
            }
        }
        return res;
    }

    public int countUniqueChars(String s) {
        int count = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        for(char c : s.toCharArray()){
            if(map.get(c) == 1){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        String s = "LEETCODE";
        System.out.println(new Solution828().uniqueLetterString(s));
    }
}
