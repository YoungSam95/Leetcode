package leetcode;

/**
 * 2535. 数组元素和与数字和的绝对差
 */
public class Solution2535 {
    public int differenceOfSum(int[] nums) {
        int elementSum = 0; // 元素和
        int digitSum = 0; // 数字和
        for (int num : nums) {
            elementSum += num;
            digitSum += digitSum(num);
        }
        return Math.abs(elementSum - digitSum);
    }

    int digitSum(int num) {
        int ans = 0;
        if (num >= 10) {
            ans += digitSum(num / 10);
        }
        return ans + num % 10;
    }
}
