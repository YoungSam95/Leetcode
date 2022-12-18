package Thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    public static void main(String[] args){
        final CountDownLatch countDownLatch = new CountDownLatch(5);
        System.out.println("现在六点下班了");

        new Thread(() -> {
            try{
                // 这⾥调⽤的是await()不是wait()
                countDownLatch.await();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("其他的5个员⼯都走了，终于可以⾛了");
        }).start();
        for(int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                System.out.println("员⼯" + finalI +"号下班了");
                countDownLatch.countDown();
            }).start();
        }
    }
}
