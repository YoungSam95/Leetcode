package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 2283. 判断一个数的数字计数是否等于数位的值
 */
public class Solution2283 {
    public boolean digitCount(String num) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < num.length(); i++) {
            int digit = num.charAt(i) - '0';
            map.put(digit, map.getOrDefault(digit,0) + 1);
        }
        for(int i = 0; i < num.length(); i++) {
            int count = num.charAt(i) - '0';
            if(count != map.getOrDefault(i,0)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        String num = "1210";
        System.out.println(new Solution2283().digitCount(num));
    }
}
