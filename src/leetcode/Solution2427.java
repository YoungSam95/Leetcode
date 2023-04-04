package leetcode;

/**
 * 2427. 公因子的数目
 */
public class Solution2427 {
    public int commonFactors(int a, int b) {
        int res = 1;
        int min = Math.min(a, b);
        for(int i = 2; i <= min; i++){
            if(a % i == 0 && b % i == 0){
                res++;
            }
        }
        return res;
    }
}
