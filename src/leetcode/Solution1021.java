package leetcode;

import java.util.Stack;

/**
 * 1021. 删除最外层的括号
 */
public class Solution1021 {
    public String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuffer res = new StringBuffer();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ')'){
                stack.pop();
            }
            if(!stack.isEmpty()){
                res.append(c);
            }
            if(c == '('){
                stack.add(c);
            }
        }
        return res.toString();
    }
}
