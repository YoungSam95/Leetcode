package leetcode;

import javafx.util.Pair;

import java.util.*;

/**
 * 826. 安排工作以达到最大收益
 */
public class Solution826 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<Pair<Integer, Integer>> jobs = new ArrayList<>();
        int N = profit.length, res = 0, i = 0, best = 0;
        for (int j = 0; j < N; ++j) {
            jobs.add(new Pair<Integer, Integer>(difficulty[j], profit[j]));
        }
        Collections.sort(jobs, Comparator.comparing(Pair::getKey));
        Arrays.sort(worker);
        for (int w : worker) {
            while (i < N && w >= jobs.get(i).getKey()) {
                best = Math.max(best, jobs.get(i).getValue());
                i++;
            }
            res += best;
        }
        return res;
    }
}
