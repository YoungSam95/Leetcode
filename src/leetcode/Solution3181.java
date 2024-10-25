package leetcode;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 3181. 执行操作可获得的最大总奖励 II
 */
public class Solution3181 {
    public int maxTotalReward(int[] rewardValues) {
        int n = rewardValues.length;
        Arrays.sort(rewardValues);
        if (n >= 2 && rewardValues[n - 2] == rewardValues[n - 1] - 1) {
            return 2 * rewardValues[n - 1] - 1;
        }
        BigInteger f = BigInteger.ONE;
        for (int x : Arrays.stream(rewardValues).distinct().toArray()) {
            BigInteger mask = BigInteger.ONE.shiftLeft(x).subtract(BigInteger.ONE);
            f = f.or(f.and(mask).shiftLeft(x));
        }
        return f.bitLength() - 1;
    }
}
