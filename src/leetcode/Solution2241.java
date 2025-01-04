package leetcode;

/**
 * 2241. 设计一个 ATM 机器
 */
public class Solution2241 {
    class ATM {
        private long[] cnt;   // 每张钞票剩余数量
        private long[] value; // 每张钞票面额

        public ATM() {
            cnt = new long[]{0, 0, 0, 0, 0};
            value = new long[]{20, 50, 100, 200, 500};
        }

        public void deposit(int[] banknotesCount) {
            for (int i = 0; i < 5; ++i) {
                cnt[i] += banknotesCount[i];
            }
        }

        public int[] withdraw(int amount) {
            int[] res = new int[5];
            // 模拟尝试取出钞票的过程
            for (int i = 4; i >= 0; --i) {
                res[i] = (int) Math.min(cnt[i], amount / value[i]);
                amount -= res[i] * value[i];
            }
            if (amount > 0) {
                // 无法完成该操作
                return new int[]{-1};
            } else {
                // 可以完成该操作
                for (int i = 0; i < 5; ++i) {
                    cnt[i] -= res[i];
                }
                return res;
            }
        }
    }
}
