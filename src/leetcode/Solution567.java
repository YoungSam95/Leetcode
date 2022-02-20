package leetcode; /**
 * 567. 字符串的排列
 *      给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 解题思路：
 *      1.用滑动窗口；
 *      2.首先字符串s1的排列的可能性应该是它的长度的阶乘，因为字符串长度可能为10000，所以找出所有排列情况是不太可能。
 *      3.不要关注排列的形式，而是关注排列中元素的数量关系；
 *      4.比如aab，那么转换为数量关系就是{a:2,b:1}，因为S1长度为3，所以滑动窗口长度也为3。
 *      5.如果在S2找到了这样一个窗口符合出现a的次数是两个，b是一个，那么S2就是包含S1的排列的。
 */

import java.util.Arrays;

public class Solution567 {

    public static boolean checkInclusion(String s1, String s2) {

        int len1 = s1.length();
        int len2 = s2.length();
        int[] c1 = new int[26];//s1字母出现次数数组
        int[] c2 = new int[26];//s2字母出现次数数组

        if(len1>len2){
            return false;
        }
        //循环统计s1中每个字母的出现次数
        for (char c : s1.toCharArray()) {
            c1[c - 'a']++;
        }

        for (int i = 0; i < len2; i++) {

            if (i >= len1) {//当窗口大于s1的长度时
                --c2[s2.charAt(i - len1) - 'a'];//先把坐标查过的减掉
            }

            c2[s2.charAt(i) - 'a']++;

            if (Arrays.equals(c1, c2)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args){

        String s1 = "ab";
        String s2 = "eidboaoo";

        System.out.print(checkInclusion(s1,s2));
    }
}
