package leetcode;

/**
 * 2520. 统计能整除数字的位数
 */
public class Solution2520 {
    public int countDigits(int num) {
        int res = 0;
        int temp = num;
        while(temp != 0) {
            int digit = temp % 10;
            if(num % digit == 0) {res++;}
            temp = temp / 10;
        }
        return res;
    }
}
