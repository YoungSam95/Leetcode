/**
 * 剑指 Offer II 072. 求平方根  只保留整数部分
 */
public class Sqrt {

    public static int mySqrt(int x) {
        //查找区间为 [1, x / 2 + 1]
        int left = 1, right = x / 2 + 1;
        //循环不变量，查找区间始终是左闭右闭
        while (left <= right) {
            //防止出现整型溢出的风险
            //int mid = left + ((right - left) >> 1);
            int mid = (left + right)/2;
            if (mid*mid > x) {
                right = mid - 1;
            } else if (mid*mid < x) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return right;
    }

    public static void main(String[] args){

        System.out.println(mySqrt(8));
    }
}
