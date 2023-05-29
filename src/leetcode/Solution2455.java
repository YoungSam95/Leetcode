package leetcode;

/**
 * 2455. 可被三整除的偶数的平均值
 */
public class Solution2455 {
    public int averageValue(int[] nums) {
        int sum = 0, n = 0;
        for(int num : nums){
            if(num % 6 ==0){
                sum += num;
                n++;
            }
        }
        return sum == 0 ? 0 : sum / n;
    }
}
