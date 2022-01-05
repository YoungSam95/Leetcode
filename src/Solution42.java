/**
 * 42.接雨水
 *    给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Solution42 {

    public static int trap(int[] height) {

        //解法一：暴力破解
        int res = 0;
        for(int i = 0; i < height.length; i++){
            int l_max = 0,r_max = 0;
            for(int j = i; j < height.length; j++)//找左边最高柱子
                r_max = Math.max(r_max,height[j]);
            for(int j = i; j >= 0; j--)//找右边最高柱子
                l_max = Math.max(l_max,height[j]);
            res += Math.min(l_max,r_max) - height[i];//i处存水量为两边最高中最小-i本身高度
        }
        return res;

    }

    public static void main(String[] args){

        int[] height = {4,2,0,3,2,5};
        System.out.println(trap(height));

    }

}
