package leetcode;

/**
 * 14. 最长公共前缀
 *     查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
 * 思路：以strs[0]为参照，竖向查找每一个strs[i].
 */
public class Solution14 {

    public static String longestCommonPrefix(String[] strs) {

        if(strs == null || strs.length == 0) return "";

        int length = strs[0].length();
        int count = strs.length;

        for(int i = 0;i<length;i++){
            char c = strs[0].charAt(i);

            for(int j = 1;j<count;j++){
                if(i == strs[j].length() || strs[j].charAt(i) != c){//遇到长度小于strs[0]的或者当前的char和strs[0]当前的char不同，结束查询
                    return strs[0].substring(0,i);
                }
            }
        }

        return strs[0];
    }

    public static void main(String[] args){

        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
