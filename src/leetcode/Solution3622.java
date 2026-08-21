package leetcode;

/**
 * 3622.判断整除性
 */
public class Solution3622 {
    public boolean checkDivisibility(int n) {
        int digitSum = 0;
        int digitProduct = 1;
        int original = n;

        while (n > 0) {
            int digit = n % 10;
            n /= 10;

            digitSum += digit;
            digitProduct *= digit;
        }

        return original % (digitSum + digitProduct) == 0;
    }
}
