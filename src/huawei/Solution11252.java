package huawei;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Solution11252 {
    public int solution (String exp){
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int index = 0;
        while(index < exp.length()){
            int num = 0;
            char op = '+';
            if(!Character.isDigit(exp.charAt(index))){
                if(exp.charAt(index) == '-'){
                    op = '-';
                }else if(exp.charAt(index) == '*'){
                    op = '*';
                }else if(exp.charAt(index) == '/'){
                    op = '/';
                }
                index++;
            }
            while(index < exp.length() && Character.isDigit(exp.charAt(index))) {
                num = num * 10 + Integer.parseInt(exp.charAt(index) + "");
                index++;
            }
            if(op == '+'){
                stack.push(num);
            }else if(op == '-'){
                stack.push(num * -1);
            }else if(op == '*'){
                stack.push(stack.pop() * num);
            }else if(op == '/'){
                stack.push(stack.pop() / num);
            }
        }
        while(!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
    public static void main(String[] args){
        String s = "1000+2*3-800/40";
        System.out.println(new Solution11252().solution(s));
    }
}
