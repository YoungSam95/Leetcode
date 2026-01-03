package leetcode;

import java.util.*;

/**
 * 1390. 四因数
 */
public class Solution1390 {
    public int sumFourDivisors(int[] nums) {
        // C 是数组 nums 元素的上限，C3 是 C 的立方根
        int C = 100000, C3 = 46;

        boolean[] isPrime = new boolean[C + 1];
        Arrays.fill(isPrime, true);
        List<Integer> primes = new ArrayList<Integer>();

        // 埃拉托斯特尼筛法
        for (int i = 2; i <= C; ++i) {
            if (isPrime[i]) {
                primes.add(i);
            }
            for (int j = i + i; j <= C; j += i) {
                isPrime[j] = false;
            }
        }

        // 欧拉筛法
        /*
        for (int i = 2; i <= C; ++i) {
            if (isPrime[i]) {
                primes.add(i);
            }
            for (int prime : primes) {
                if (i * prime > C) {
                    break;
                }
                isPrime[i * prime] = false;
                if (i % prime == 0) {
                    break;
                }
            }
        }
        */

        // 通过质数表构造出所有的四因数
        Map<Integer, Integer> factor4 = new HashMap<Integer, Integer>();
        for (int prime : primes) {
            if (prime <= C3) {
                factor4.put(prime * prime * prime, 1 + prime + prime * prime + prime * prime * prime);
            }
        }
        for (int i = 0; i < primes.size(); ++i) {
            for (int j = i + 1; j < primes.size(); ++j) {
                if (primes.get(i) <= C / primes.get(j)) {
                    factor4.put(primes.get(i) * primes.get(j), 1 + primes.get(i) + primes.get(j) + primes.get(i) * primes.get(j));
                } else {
                    break;
                }
            }
        }

        int ans = 0;
        for (int num : nums) {
            if (factor4.containsKey(num)) {
                ans += factor4.get(num);
            }
        }
        return ans;
    }
}
