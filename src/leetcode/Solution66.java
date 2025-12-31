package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 66.加一
 * 第二次
 */
public class Solution66 {
    public static int[] plusOne(int[] digits) {

        /*List<Integer> list = new ArrayList<>();
        list.add((digits[digits.length-1]+1)%10);
        int carry = (digits[digits.length-1]+1)/10;
        for(int i = digits.length - 2; i >= 0; i--){
            list.add((digits[i]+carry)%10);
            carry = (digits[i]+carry)/10;
        }
        if(carry != 0) list.add(carry);
        int[] res = new int[list.size()];
        for(int i = list.size() - 1,j = 0; i >= 0; i--){
            res[i] = list.get(j++);
        }
        return res;*/
        for (int i = digits.length - 1; i >= 0; --i) {
            if (digits[i] != 9) {
                ++digits[i];
                for (int j = i + 1; j < digits.length; ++j) {
                    digits[j] = 0;
                }
                return digits;
            }
        }

        // digits 中所有的元素均为 9
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
    public static void main(String[] args){
        int[] digis = {9,9};
        int[] res = plusOne(digis);
        for(int i : res){
            System.out.println(i);
        }
    }
}
