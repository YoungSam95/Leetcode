package leetcode;

/**
 * 2169. 得到 0 的操作数
 */
public class Solution2169 {
    public int countOperations(int num1, int num2) {
        int res = 0;   // 相减操作的总次数
        while (num1 != 0 && num2 != 0) {
            // 每一步辗转相除操作
            res += num1 / num2;
            num1 %= num2;
            // 交换两个数
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }
        return res;
    }
}
