package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 761. 特殊的二进制序列
 * 第二次
 */
public class Solution761 {
    public String makeLargestSpecial(String s) {
        int count = 0,left = 0,n = s.length();
        if(n == 0){return "";}
        List<String> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(c == '1'){
                count++;
            } else{
                count--;
                if(count == 0){
                    list.add("1" + makeLargestSpecial(s.substring(left + 1,i)) + "0");
                    left = i + 1;
                }
            }
        }
        Collections.sort(list);
        String res = "";
        for(int i = list.size()-1; i >=0 ; i--){
            res += list.get(i);
        }
        return res;
    }
}
