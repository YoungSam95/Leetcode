package leetcode; /**
 * 71. 简化路径
 *     以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 *     在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。
 *     请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 * 解题思路：
 *      利用栈的特性，将有效路径名压入
 *      当遇到 .. 时 pop 栈
 *      最后按顺序 pop 组成最终路径
 */

import java.util.ArrayDeque;

public class Solution71 {

    public static String simplifyPath(String path){
        ArrayDeque<String> stack = new ArrayDeque<>();
        //String[] split = path.split("/");
        String[] split = path.split("/+");
        for(String s : split){
            if(s.isEmpty()){
                continue;
            }
            switch(s){
                case "..":
                    stack.pollLast();
                    break;
                case ".":
                    break;
                default :
                    stack.offerLast(s);
            }
        }

        StringBuilder builder = new StringBuilder("/");
        for(String s : stack){
            builder.append(s);
            builder.append("/");
        }

        if(builder.length() > 1){
            builder.deleteCharAt(builder.length() - 1);
        }

        return builder.toString();
    }

    public static void main(String[] args){

        String path = "/a/../../b/../c//.//";
        System.out.println(simplifyPath(path));
    }

}
