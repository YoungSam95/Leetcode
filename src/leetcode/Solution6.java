package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. Z 字形变换
 */

public class Solution6 {
    public String convert(String s, int numRows) {
        if(numRows < 2) return s;
        List<StringBuilder> list = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            list.add(new StringBuilder());
        }
        int index = 0, dir = -1;
        for(char c : s.toCharArray()){
            list.get(index).append(c);
            if(index == 0 || index == numRows - 1) dir *= -1;
            index += dir;
        }
        for(int i = 1; i < numRows; i++){
            list.get(0).append(list.get(i));
        }
        return list.get(0).toString();
    }
    public static void main(String[] args){
        String s = "AB";
        System.out.println(new Solution6().convert(s,1));
    }
}
