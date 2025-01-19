package leetcode;

/**
 * 2239. 找到最接近 0 的数字
 */
public class Solution2239 {
    public int findClosestNumber(int[] nums) {
        int res = nums[0];   // 已遍历元素中绝对值最小且数值最大的元素
        int dis = Math.abs(nums[0]);   // 已遍历元素的最小绝对值
        for (int num : nums) {
            if (Math.abs(num) < dis) {
                dis = Math.abs(num);
                res = num;
            } else if (Math.abs(num) == dis) {
                res = Math.max(res, num);
            }
        }
        return res;
    }
}
