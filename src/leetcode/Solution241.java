package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 241. 为运算表达式设计优先级
 * 思路：分治
 *      将原表达式按照运算符分隔成左右两部分，分别进行递归
 */
public class Solution241 {
    private Map<String,List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String expression) {
        if(map.containsKey(expression)) return map.get(expression);
        List<Integer> res = new LinkedList<>();
        for(int i = 0; i < expression.length(); i++){
            char c = expression.charAt(i);
            if(c == '+' || c == '-' || c == '*'){
                List<Integer> left = diffWaysToCompute(expression.substring(0,i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                for(int a : left){
                    for(int b : right){
                        if(c == '+'){
                            res.add(a + b);
                        }else if(c == '-'){
                            res.add(a - b);
                        }else if(c == '*'){
                            res.add(a * b);
                        }
                    }
                }
            }
        }
        if(res.isEmpty()){
            res.add(Integer.parseInt(expression));
        }
        map.put(expression,res);
        return res;
    }
}