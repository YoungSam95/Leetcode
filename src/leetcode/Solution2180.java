package leetcode;

/**
 * 2180. 统计各位数字之和为偶数的整数个数
 */
public class Solution2180 {
    public int countEven(int num) {
        int res = 0;
        for(int i = 2; i <= num; i++) {
            int sum = 0, n = i;
            while(n != 0) {
                sum += n % 10;
                n = n / 10;
            }
            if(sum % 2 == 0) {
                res++;
            }
        }
        return res;
    }
}
