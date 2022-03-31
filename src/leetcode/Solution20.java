package leetcode;

import java.util.Stack;

/**
 * 20.有效的括号
 */

public class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> left = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                left.push(c);
            }else{
                if(!left.isEmpty() && leftOf(c) == left.peek()){
                    left.pop();
                }else{
                    return false;
                }
            }
        }
        return left.isEmpty();
    }

    public char leftOf(char c) {
        if(c == ')') return '(';
        if(c == '}') return '{';
        return '[';
    }
}
