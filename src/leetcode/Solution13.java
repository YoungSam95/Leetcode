package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 13.罗马数字转整数
 */

public class Solution13 {

    public static int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int i = 0;
        int res = 0;
        while(i < s.length()){
            if(i+1 < s.length() && map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                res += map.get(s.charAt(i+1)) - map.get(s.charAt(i));
                i += 2;
            }else{
                res += map.get(s.charAt(i));
                i +=1;
            }
        }
        return res;
    }
    public static void main(String[] args){
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }
}
