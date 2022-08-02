package leetcode;

import java.util.Arrays;

/**
 * 899. 有序队列
 * 思路：1.当k=1时，每次都把首位字符移到末尾，找到字典序最小；
 *      2.当k>1时，总共可以使各个位置的字符按升序排列；
 */
public class Solution899 {
    public String orderlyQueue(String s, int k) {
        if(k == 1){
            String small = s;
            StringBuilder sb = new StringBuilder(s);
            for(int i = 1; i < s.length(); i++){
                char c = sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(c);
                if(sb.toString().compareTo(small) < 0){
                    small = sb.toString();
                }
            }
            return small;
        }else{
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            return new String(arr);
        }
    }
}
