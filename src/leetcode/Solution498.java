package leetcode;

/**
 * 498. 对角线遍历
 * 第二次
 */
public class Solution498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int x = 0, y = 0, index = 0;
        boolean flag = true;
        int[] res = new int[m * n];
        while(index < m * n){
            res[index++] = mat[x][y];
            if(flag){//向斜上
                if(x - 1 >= 0){
                    if(y + 1 < n){
                        x--;
                        y++;
                    }else{
                        x++;
                        flag = false;
                    }
                }else{
                    if(y + 1 < n){
                        y++;
                        flag = false;
                    }else{
                        x++;
                        flag = false;
                    }
                }
            }else{//向斜下
                if(x + 1 < m){
                    if(y - 1 >= 0){
                        x++;
                        y--;
                    }else{
                        x++;
                        flag = true;
                    }
                }else{
                   y++;
                   flag = true;
                }
            }
        }
        return res;
    }
}
