/**
 * 69. x 的平方根
 *      计算并返回 x 的平方根，其中 x 是非负整数。由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 */
public class Solution69 {

    public static int mySqrt(int x) {

        //二分查找
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;

        /*//牛顿迭代法
         double a = 1, diff = 0;

         do {
             a = (x / a + a) / 2.0;
             diff = Math.abs(a * a - x);
         } while (diff > 0.1);

         return (int) a;*/
    }

    public static void main(String[] args){

        int a = 10;
        System.out.println(mySqrt(a));
    }
}
