package codingInterviews;

/**
 * 剑指 Offer II 072. 求平方根  只保留整数部分
 */
public class Solution072 {

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
    public static final String A = "ab";
    public static void main(String[] args){

        //System.out.println(mySqrt(8));
        String s = "ab";
        String a = "a";
        String b = "b";
        String c = a + b;//ab为引用不是字符串常量，不会在编译期确定 String是final的所以创建了一个新的对向然后把引用传给c
        String d = new String("ab");
        String e = "a" + "b";
        System.out.println(A == s);
        System.out.println(A == c);
        System.out.println(A == s.intern());
        System.out.println(A == c.intern());
        System.out.println(A == d);
        System.out.println(s == d);
        System.out.println(s == e);
        System.out.println(A == e);
    }
}
