package leetcode;

/**
 * 1785. 构成特定和需要添加的最少元素
 */
public class Solution1785 {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for(int num : nums){
            sum += num;
        }
        sum = Math.abs(sum - goal);
        return (int) (sum % limit == 0 ? sum / limit : sum / limit + 1);
    }
}
