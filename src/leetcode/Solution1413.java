package leetcode;

/**
 * 1413. 逐步求和得到正数的最小值
 */
public class Solution1413 {
    public int minStartValue(int[] nums) {
        int startValue = 0;
        int sum = 0;
        for(int num : nums){
            sum += num;
            if(sum < 1) {
                startValue = startValue + 1 - sum;
                sum = 1;
            }
        }
        return startValue;
    }
    //前缀和解法
    public int minStartValue2(int[] nums) {
        int sum = 0, minSum = 0;
        for(int num : nums){
            sum += num;
            minSum = Math.min(minSum,sum);
        }
        return 1 - minSum;
    }

    public static void main(String[] args){
        Solution1413 s = new Solution1413();
        int[] nums = {-3,2,-3,4,2};
        System.out.println(s.minStartValue(nums));
    }
}
