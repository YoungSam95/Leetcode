/**
 * 42.接雨水
 *    给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Solution42 {

    public static int trap(int[] height) {

        /*//解法1：暴力破解
        int res = 0;
        for(int i = 0; i < height.length; i++){
            int l_max = 0,r_max = 0;
            for(int j = i; j < height.length; j++)//找左边最高柱子
                r_max = Math.max(r_max,height[j]);
            for(int j = i; j >= 0; j--)//找右边最高柱子
                l_max = Math.max(l_max,height[j]);
            res += Math.min(l_max,r_max) - height[i];//i处存水量为两边最高中最小-i本身高度
        }*/
        /*//解法2：备忘录优化
        int res = 0;
        int[] l_max = new int[height.length];
        int[] r_max = new int[height.length];
        l_max[0] = height[0];
        r_max[height.length - 1] = height[height.length - 1];
        for(int i = 1; i < height.length; i++)//从左到右遍历找出i左边最高柱子
            l_max[i] = Math.max(l_max[i - 1],height[i]);
        for(int i = height.length - 2; i >= 0; i--)//从右到左遍历找出i右边最高柱子
            r_max[i] = Math.max(r_max[i + 1],height[i]);
        for(int i = 0; i < height.length; i++){
            res += Math.min(l_max[i],r_max[i]) - height[i];
        }*/
        //解法3：双指针
        int res = 0;
        int left = 0, right = height.length - 1;
        int l_max = 0, r_max = 0;
        while(left < right){
            l_max = Math.max(l_max,height[left]);
            r_max = Math.max(r_max,height[right]);
            if(l_max < r_max){
                res += l_max - height[left];
                left++;
            }else{
                res += r_max - height[right];
                right--;
            }
        }
        return res;

    }

    public static void main(String[] args){

        int[] height1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height2 = {4,2,0,3,2,5};
        int[] height3 = {1,0,3,0,1};
        System.out.println(trap(height1));
        System.out.println(trap(height2));
        System.out.println(trap(height3));

    }

}
