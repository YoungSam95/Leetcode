package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 828. 统计子串中的唯一字符
 */
public class Solution828 {
    public int uniqueLetterString1(String s) {
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

    public int uniqueLetterString(String s) {
        Map<Character, List<Integer>> index = new HashMap<Character, List<Integer>>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!index.containsKey(c)) {
                index.put(c, new ArrayList<Integer>());
                index.get(c).add(-1);
            }
            index.get(c).add(i);
        }
        int res = 0;
        for (Map.Entry<Character, List<Integer>> entry : index.entrySet()) {
            List<Integer> arr = entry.getValue();
            arr.add(s.length());
            for (int i = 1; i < arr.size() - 1; i++) {
                res += (arr.get(i) - arr.get(i - 1)) * (arr.get(i + 1) - arr.get(i));
            }
        }
        return res;
    }
    public static void main(String[] args){
        String s = "ABC";
        System.out.println(new Solution828().uniqueLetterString(s));
    }
}
