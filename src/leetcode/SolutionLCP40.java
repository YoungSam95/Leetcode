package leetcode;

/**
 * LCP 40. 心算挑战
 */
public class SolutionLCP40 {
    public int maxmiumScore(int[] cards, int cnt) {
        int[] val = new int[1001];
        for (int i = 0; i < cards.length; i++) {
            val[cards[i]]++;
        }

        int ans = 0;
        int tmp = 0;
        int ed = -1;
        int odd = -1, even = -1;
        for (int i = 1000; i >= 1; i--) {
            if (val[i] == 0) {
                continue;
            }

            if (val[i] > cnt) {
                tmp += cnt * i;
                cnt = 0;
            } else {
                tmp += val[i] * i;
                cnt -= val[i];
                val[i] = 0;
            }

            if ((i & 1) != 0) {
                odd = i;
            } else {
                even = i;
            }

            if (cnt == 0) {
                if (val[i] > 0) {
                    ed = i;
                } else {
                    ed = i - 1;
                }
                break;
            }
        }

        if ((tmp & 1) == 0) {
            return tmp;
        }

        for (int i = ed; i >= 1; i--) {
            if (val[i] == 0) {
                continue;
            }

            if ((i & 1) != 0) {
                if (even != -1) {
                    ans = Math.max(ans, tmp - even + i);
                }
            } else {
                if (odd != -1) {
                    ans = Math.max(ans, tmp - odd + i);
                }
            }
        }

        return ans;
    }
}
