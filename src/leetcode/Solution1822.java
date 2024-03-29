package leetcode;

/**
 * 1822. 数组元素积的符号
 */
public class Solution1822 {
    public int arraySign(int[] nums) {
        int sign = 1;
        for(int num : nums){
            if(num == 0){
                return 0;
            }else if(num < 0){
                sign = -sign;
            }
        }
        return sign;
    }
}
