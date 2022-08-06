package leetcode;

/**
 * 636. 函数的独占时间
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Solution636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Deque<int[]> stack = new ArrayDeque<>();
        for(String log : logs){
            String[] str = log.split(":");
            int idx = Integer.parseInt(str[0]);//函数标志
            String type = str[1];//函数执行类型
            int timestamp = Integer.parseInt(str[2]);//函数时间戳
            if("start".equals(type)){
                /**
                 * 如果栈不为空，将栈顶函数暂停，计算其当前运行的时间，并将其开始时间戳更改为当前函数的开始时间
                 */
                if(!stack.isEmpty()){
                    res[stack.peek()[0]] += timestamp - stack.peek()[1];
                    stack.peek()[1] = timestamp;
                }
                /**如果栈为空，则直接将当前函数信息入栈**/
                stack.push(new int[] {idx,timestamp});
            }else {
                /**
                 * 如果类型是终止，则栈顶函数与当前必定是同一个函数，出栈并计算其运行时间
                 */
                int[] t = stack.pop();
                res[t[0]] += timestamp - t[1] + 1;
                if(!stack.isEmpty()){
                    stack.peek()[1] = timestamp + 1;
                }
            }
        }
        return res;
    }
}
