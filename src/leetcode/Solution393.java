package leetcode;

/**
 * 393. UTF-8 编码验证
 */
public class Solution393 {

    public static boolean validUtf8(int[] data) {
        // 记录UTF-8字符的字节数
        int numberOfBytesToProcess = 0;

        // 循环处理数组中每一个数
        for (int i = 0; i < data.length; i++) {

            //将每个数转换为2进制字符串，长度大于8取最后8位，长度小于8前面补0补到8位
            String binRep = Integer.toBinaryString(data[i]);
            binRep =
                    binRep.length() >= 8
                            ? binRep.substring(binRep.length() - 8)
                            : "00000000".substring(binRep.length() % 8) + binRep;

            // 这种情况表示开始处理一个新的待定UTF-8字符
            if (numberOfBytesToProcess == 0) {

                //找到当前数是以几个1开头的，决定待处理字符是几个字节
                for (int j = 0; j < binRep.length(); j++) {
                    if (binRep.charAt(j) == '0') {
                        break;
                    }

                    numberOfBytesToProcess += 1;
                }

                // 如果是以0开头的 说明当前数表示一个1字节的字符，跳出循环处理下一个数
                if (numberOfBytesToProcess == 0) {
                    continue;
                }

                // 如果字节数的个数大于4或者等于1，直接返回false
                if (numberOfBytesToProcess > 4 || numberOfBytesToProcess == 1) {
                    return false;
                }

            } else {//这种情况表示要处理的是UTF-8字符的剩余部分，并且每个剩余部分都是以“10”开头的

                if (!(binRep.charAt(0) == '1' && binRep.charAt(1) == '0')) {
                    //不满足直接返回false
                    return false;
                }
            }

            //每处理一个合法的数，就将字符的字节记录数减少一个
            numberOfBytesToProcess -= 1;
        }

        // 如果记录字符字节数的值不等于0，说明字节不完整，返回false
        return numberOfBytesToProcess == 0;
    }

    public static void main(String[] args){
        int[] nums1 = {197, 130, 1};
        int[] nums2 = {235, 140, 4};
        System.out.print(validUtf8(nums1));
        System.out.print(validUtf8(nums2));
    }
}
