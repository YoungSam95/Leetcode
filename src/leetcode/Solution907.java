package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 907. 子数组的最小值之和
 * 第二次
 */
public class Solution907 {
    /**
     *3次遍历
     * 用left和right数组记录arr[i]的左右边界
     */
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long res = 0;
        final int MOD = 1000000007;

        Deque<Integer> stack = new ArrayDeque<>();
        int[] left = new int[n];
        int[] right = new int[n];

        stack.push(-1);
        for(int i = 0; i < n; i++){
            //当栈顶元素大于等于当前元素时，说明其在当前元素的辐射范围内，出栈
            while(stack.size() > 1 && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            //此时栈顶元素即为当前元素的左边界
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

    /**
     * 2次遍历
     *因为在计算left的过程中，如果栈顶元素≥arr[i]，那么i就是栈顶元素的右边界，因此前两个循环可以合并。
     */
    public int sumSubarrayMinsV2(int[] arr) {
        int n = arr.length;
        long res = 0;
        final int MOD = 1000000007;

        Deque<Integer> stack = new ArrayDeque<>();
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right,n);

        stack.push(-1);
        for(int i = 0; i < n; i++){
            //当栈顶元素大于等于当前元素时，说明其在当前元素的辐射范围内，出栈
            while(stack.size() > 1 && arr[stack.peek()] >= arr[i]){
                right[stack.pop()] = i;//当前元素为栈顶元素的右边界
            }
            //此时栈顶元素即为当前元素的左边界
            left[i] = stack.peek();
            stack.push(i);
        }

        for (int  i = 0; i < n; i++)
            res += (long) arr[i] * (i - left[i]) * (right[i] - i);
        return (int) (res % MOD);
    }

    /**
     * 1次遍历
     * 由于栈顶下面的元素正好也是栈顶的左边界，所以甚至连left和right数组都可以不要，直接在出栈的时候计算贡献。
     * 为简化代码逻辑，可以在遍历前，往arr末尾和栈顶分别加一个-1，当作哨兵。
     */
    public int sumSubarrayMinsV3(int[] arr) {
        int n = arr.length;
        long res = 0;
        final int MOD = 1000000007;

        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(-1);//哨兵
        for(int i = 0; i <= n; i++){
            int temp = i < n ? arr[i] : -1;//假设arr末尾有一个-1
            while(stack.size() > 1 && arr[stack.peek()] >= temp){
                int base = stack.pop();//此时栈顶为其左边界，arr[i]为其右边界
                res += (long) arr[base] * (base - stack.peek()) * (i - base);
            }
            stack.push(i);
        }
        return (int) (res % MOD);
    }
}
