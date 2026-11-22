package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1352. 最后 K 个数的乘积
 */
public class Solution1352 {
    class ProductOfNumbers {
        private List<Integer> nums;
        private List<Integer> zeroCount;
        private List<Integer> prevNonOne;
        private int n;

        public ProductOfNumbers() {
            nums = new ArrayList<>();
            zeroCount = new ArrayList<>();
            prevNonOne = new ArrayList<>();
            n = 0;
        }

        public void add(int num) {
            n++;
            nums.add(num);

            prevNonOne.add(-1);
            if (n > 1) {
                if (nums.get(n-2) != 1 && nums.get(n-2) != 0) {
                    prevNonOne.set(n-1, n-2);
                } else {
                    prevNonOne.set(n-1, prevNonOne.get(n-2));
                }
            }

            zeroCount.add(num == 0 ? 1 : 0);
            if (n > 1) {
                zeroCount.set(n-1, zeroCount.get(n-1) + zeroCount.get(n-2));
            }
        }

        public int getProduct(int k) {
            int totalZeros = zeroCount.get(n-1);
            if (n - k >= 1) {
                totalZeros -= zeroCount.get(n-1-k);
            }
            if (totalZeros > 0) {
                return 0;
            }

            int ans = 1;
            for (int i = n - 1; i >= n - k; ) {
                ans *= nums.get(i);
                i = prevNonOne.get(i);
            }
            return ans;
        }
    }

}
