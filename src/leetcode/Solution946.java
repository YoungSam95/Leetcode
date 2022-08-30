package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 946. 验证栈序列
 */
public class Solution946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = pushed.length;
        for(int i = 0, j = 0; i < n; i++){
            stack.push(pushed[i]);
            while(!stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
