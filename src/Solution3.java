/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 解题思路：滑动窗口；
 *         用Map记录字符所在位置，遇到重复字符时，移动start指针；
 *         替换Map中下标，计算子串长度；
 */

import java.util.HashMap;

public class Solution3 {

    public static int lengthOfLongestSubstring(String s) {

        if(s == null || s.length() == 0) return 0;

        HashMap<Character,Integer> temp = new HashMap<>();
        char[] chars = s.toCharArray();

        int res = 0,start = 0;

        for(int i = 0;i < chars.length;i++){
            if(temp.containsKey(chars[i])){
                start = Math.max(temp.put(chars[i], i) + 1, start);//.put()返回重复之前的value值,无重复返回NUL;
            }

            temp.put(chars[i],i);
            res = Math.max(res,i-start+1);
        }

        return res;
    }
    public static void main(String[] args){

        String s = "qwerjijrewqrewqrwerq";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
