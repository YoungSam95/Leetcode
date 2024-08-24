package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 698. 划分为k个相等的子集
 * 第二次
 */
public class Solution698 {
    /*public HashMap<Integer, Boolean> memo = new HashMap<>();

    public boolean canPartitionKSubsets(int[] nums, int k) {
        // 排除一些基本情况
        if (k > nums.length) return false;
        int sum = 0;
        for (int v : nums) sum += v;
        if (sum % k != 0) return false;

        int used = 0; // 使用位图技巧
        int target = sum / k;
        // k 号桶初始什么都没装，从 nums[0] 开始做选择
        return backtrack(k, 0, nums, 0, used, target);
    }

    public boolean backtrack(int k, int bucket,
                      int[] nums, int start, int used, int target) {
        // base case
        if (k == 0) {
            // 所有桶都被装满了，而且 nums 一定全部用完了
            return true;
        }
        if (bucket == target) {
            // 装满了当前桶，递归穷举下一个桶的选择
            // 让下一个桶从 nums[0] 开始选数字
            boolean res = backtrack(k - 1, 0, nums, 0, used, target);
            // 缓存结果
            memo.put(used, res);
            return res;
        }

        if (memo.containsKey(used)) {
            // 避免冗余计算
            return memo.get(used);
        }

        for (int i = start; i < nums.length; i++) {
            // 剪枝
            if (((used >> i) & 1) == 1) { // 判断第 i 位是否是 1
                // nums[i] 已经被装入别的桶中
                continue;
            }
            if (nums[i] + bucket > target) {
                continue;
            }
            // 做选择
            used |= 1 << i; // 将第 i 位置为 1
            bucket += nums[i];
            // 递归穷举下一个数字是否装入当前桶
            if (backtrack(k, bucket, nums, i + 1, used, target)) {
                return true;
            }
            // 撤销选择
            used ^= 1 << i; // 使用异或运算将第 i 位恢复 0
            bucket -= nums[i];
        }

        return false;
    }*/

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];
        if (sum % k != 0) return false;
        int target = sum / k;
        // 排序优化
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        return backtrack(nums, 0, new int[k], k, target);
    }
    private boolean backtrack(int[] nums, int index, int[] bucket, int k, int target) {
        // 结束条件优化
        if (index == nums.length) return true;
        for (int i = 0; i < k; i++) {
            // 优化点二
            if (i > 0 && bucket[i] == bucket[i - 1]) continue;
            // 剪枝
            if (bucket[i] + nums[index] > target) continue;
            bucket[i] += nums[index];
            if (backtrack(nums, index + 1, bucket, k, target)) return true;
            bucket[i] -= nums[index];
        }
        return false;
    }
}
