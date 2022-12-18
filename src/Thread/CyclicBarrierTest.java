package Thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    public static void main(String[] args){
        final CyclicBarrier CyclicBarrier = new CyclicBarrier(2);
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                String name = Thread.currentThread().getName();
                if (name.equals("Thread-0")) {
                    name = "ysen";
                } else {
                    name = "⼥朋友";
                }
                System.out.println(name + "到了观前街");
                try {
                    // 两个⼈都要到观前街才能发朋友圈
                    CyclicBarrier.await();
                    // 他俩到达了观前街，看⻅了对⽅发了⼀条朋友圈：
                    System.out.println("去吃东⻄~");
                    // 回家
                    CyclicBarrier.await();
                    System.out.println(name + "洗澡");
                    // 洗澡完之后⼀起聊天
                    CyclicBarrier.await();
                    System.out.println("⼀起聊天");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
            } }).start();
        }
    }
}
