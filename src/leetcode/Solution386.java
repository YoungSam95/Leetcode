package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 386. 字典序排数
 */
public class Solution386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        int num = 1;
        for(int i = 0; i < n; i++){
            res.add(num);
            if(num * 10 <= n){
                num *= 10;
            }else{
                while(num % 10 == 9 || num + 1 > n){
                    num /= 10;
                }
                num++;
            }
        }
        return res;
    }
}
