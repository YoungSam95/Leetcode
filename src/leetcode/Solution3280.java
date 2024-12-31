package leetcode;

/**
 * 3280. 将日期转换为二进制表示
 */
public class Solution3280 {
    private String binary(int x) {
        StringBuilder s = new StringBuilder();
        for (; x != 0; x >>= 1) {
            s.append(x & 1);
        }
        return s.reverse().toString();
    }

    public String convertDateToBinary(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));
        return binary(year) + "-" + binary(month) + "-" + binary(day);
    }
}
