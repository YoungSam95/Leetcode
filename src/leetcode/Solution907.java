package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 907. 子数组的最小值之和
 */
public class Solution907 {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long res = 0;
        final int MOD = 1000000007;

        Deque<Integer> stack = new ArrayDeque<>();
        int[] left = new int[n];
        int[] right = new int[n];

        stack.push(-1);
        for(int i = 0; i < n; i++){
            while(stack.size() > 1 && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            left[i] = stack.peek();
            stack.push(i);
        }

        stack.clear();
        stack.push(n);
        for(int i = n - 1; i >= 0; i--){
            while(stack.size() > 1 && arr[stack.peek()] > arr[i]){
                stack.pop();
            }
            right[i] = stack.peek();
            stack.push(i);
        }

        for (int  i = 0; i < n; i++)
            res += (long) arr[i] * (i - left[i]) * (right[i] - i);
        return (int) (res % MOD);
    }
}
