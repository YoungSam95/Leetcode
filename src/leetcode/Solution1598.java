package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1598. 文件夹操作日志搜集器
 */
public class Solution1598 {
    public int minOperations(String[] logs) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < logs.length; i++){
            if(logs[i].equals("../")){
                if(stack.isEmpty()){
                    continue;
                }else{
                    stack.pop();
                }
            }else if(logs[i].equals("./")){
                continue;
            }else{
                stack.push(1);
            }
        }
        return stack.size();
    }
    public int minOperations2(String[] logs) {
        int res = 0;
        for(int i = 0; i < logs.length; i++){
            if(logs[i].equals("../")){
                if(res == 0){
                    continue;
                }else{
                    res--;
                }
            }else if(logs[i].equals("./")){
                continue;
            }else{
                res++;
            }
        }
        return res;
    }
}
