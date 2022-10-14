package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1441. 用栈操作构建数组
 */
public class Solution1441 {
    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        int num = 1;
        for(int i = 0; i < target.length; i++){
            while(num <= n){
                list.add("Push");
                if(target[i] == num){
                    num++;
                    break;
                }else{
                    list.add("Pop");
                }
                num++;
            }
        }
        return list;
    }
    public static void main(String[] args){
        int[] target = {1,3};
        int n = 3;
        System.out.println(new Solution1441().buildArray(target,n));
    }
}
