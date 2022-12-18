package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AtomicTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        Count count = new Count();
        //100个线程对共享变量进行+1
        for(int i = 0; i < 100; i++) {
            service.execute(() -> count.increase());
        }
        // 等待上述的线程执⾏完
        service.shutdown();
        service.awaitTermination(1, TimeUnit.DAYS);
        System.out.println(count.getCount());
    }
    static class Count{
        private Integer count = 0;
        public Integer getCount() { return count; }
        public synchronized void increase(){count++;}
    }
}
