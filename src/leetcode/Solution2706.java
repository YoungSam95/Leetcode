package leetcode;

/**
 * 2706. 购买两块巧克力
 */
public class Solution2706 {
    public int buyChoco(int[] prices, int money) {
        int fi = Integer.MAX_VALUE, se = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < fi) {
                se = fi;
                fi = price;
            } else if (price < se) {
                se = price;
            }
        }
        return money < fi + se ? money : money - fi - se;
    }
}
