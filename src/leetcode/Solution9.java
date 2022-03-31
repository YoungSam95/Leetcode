package leetcode;

/**
 * 9.回文数字
 */
public class Solution9 {

    public boolean isPalindrome(int x) {

        if(x < 0 || x%10 ==0 && x != 0) return false;
        if(x == 0) return true;
        int revers = 0;
        while(x > revers){
            revers = revers * 10 + x%10;
            x = x/10;
        }
        return x == revers || x == revers/10;
    }
}
