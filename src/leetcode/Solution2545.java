package leetcode;

import java.util.Arrays;

/**
 * 2545. 根据第 K 场考试的分数排序
 */
public class Solution2545 {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (u, v) -> v[k] - u[k]);
        return score;
    }
}
