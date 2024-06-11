package leetcode;

/**
 * 2806. 取整购买后的账户余额
 */
public class Solution2806 {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int r = purchaseAmount % 10;
        if (r < 5) {
            purchaseAmount -= r;
        } else {
            purchaseAmount += 10 - r;
        }
        return 100 - purchaseAmount;
    }
}
