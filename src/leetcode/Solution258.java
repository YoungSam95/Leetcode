package leetcode;

/**
 * 258. 各位相加
 * 思路：num和num各位相加模9相同
* */

public class Solution258 {

    public static int addDigits(int num) {

        if (num == 0){
            return 0;
        }else{
            return num % 9 == 0 ? 9 : num % 9;
        }

    }

    public static void main(String[] args){
        System.out.println(addDigits(38));
    }
}
