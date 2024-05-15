package leetcode;

/**
 * 1953. 你可以工作的最大周数
 */
public class Solution1953 {
    public long numberOfWeeks(int[] milestones) {
        int longest = milestones[0]; // 耗时最长工作所需周数
        long rest = 0;
        for (int count : milestones) {
            longest = Math.max(longest, count);
            rest += count;
        }
        // 其余工作共计所需周数
        rest -= longest;
        if (longest > rest + 1) {
            // 此时无法完成所耗时最长的工作
            return rest * 2 + 1;
        } else {
            // 此时可以完成所有工作
            return longest + rest;
        }
    }
}
