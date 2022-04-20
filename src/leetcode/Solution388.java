package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 388. 文件的最长绝对路径
 */
public class Solution388 {

    public static int lengthLongestPath(String input) {
        int n = input.length();
        int index = 0;
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        while(index < n){
            /**文件的层级**/
            int level = 1;
            while(index < n && input.charAt(index) == '\t'){
                index++;
                level++;
            }
            /**文件名长度**/
            boolean isFile = false;
            int len = 0;
            while(index < n && input.charAt(index) != '\n'){
                if(input.charAt(index) == '.') isFile = true;
                len++;
                index++;
            }
            index++;//跳过换行符
            /**栈元素个数大于等于层级，说明当前文件(夹)不是栈顶的子文件(夹)**/
            while(stack.size() >= level){
                stack.pop();
            }
            if(!stack.isEmpty()){
                len += stack.peek() + 1;//按照要求加入'/'的长度
            }
            if(isFile){
                res = Math.max(res,len);
            }else{
                stack.push(len);
            }
        }
        return res;
    }
    public static void main(String[] args){
        String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        System.out.println(lengthLongestPath(input));
    }
}
