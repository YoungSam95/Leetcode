package leetcode;

/**
 * LCP 50. 宝石补给
 */
public class SolutionLCP50 {
    public int giveGem(int[] gem, int[][] operations) {
        for(int[] operation : operations){
            int give = operation[0], get = operation[1];
            int half = gem[give] / 2;
            gem[give] -= half;
            gem[get] += half;
        }
        int min = gem[0], max = gem[0];
        for(int count : gem){
            min = Math.min(min,count);
            max = Math.max(max,count);
        }
        return max - min;
    }
}
