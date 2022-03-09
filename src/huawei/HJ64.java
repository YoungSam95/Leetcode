package huawei;

import java.util.Scanner;

public class HJ64 {

    public static void  main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String str = sc.next();
            mp3(str,n);
        }
    }

    private static void mp3(String str, int n) {
        //屏幕起始位置
        int start = 1;
        //屏幕最后位置
        int end = Math.min(4,n);
        //光标位置
        int index = 1;
        for(int i = 0; i < str.length(); i++){
            //格局输入操作计算光标
            if(str.charAt(i) == 'U') {
                index = (index-1-1+n) % n + 1;
            } else if(str.charAt(i) == 'D') {
                index = index % n + 1;
            }
            // 判断滑动窗口的位置是否需要改变
            if(index < start) {
                // 光标在窗口之上
                start = index;
                end = start + 3;
            } else if(index > end){
                // 光标在窗口之下
                end = index;
                start = end - 3;
            }
        }
        // 输出窗口内容
        for(int i = start; i <= end; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        // 打印当前光标
        System.out.println(index);
    }
}
