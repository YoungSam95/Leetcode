package leetcode;

import java.util.Arrays;

/**
 * 1652. 拆炸弹
 */
public class Solution1652 {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        if(k == 0){
            Arrays.fill(res,0);
        }else{
            if(k > 0){
                for(int i = 0; i < n; i++){
                    for(int j = i + 1, count = 0; count < k; count++, j++){
                        res[i] += code[j % n];
                    }
                }
            }else{
                for(int i = 0; i < n; i++){
                    for(int j = i - 1, count = 0; count < -k; count++, j--){
                        if(j < 0){
                            j = n - 1;
                        }
                        res[i] += code[j % n];
                    }
                }
            }
        }
        return res;
    }
}
