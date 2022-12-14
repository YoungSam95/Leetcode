package Thread;

public class SynchronizedDemo {
    //synchronized修饰⾮静态⽅法
    public synchronized void function() throws InterruptedException {
        for (int i = 0; i <3; i++) {
            Thread.sleep(1000);
            System.out.println("function running...");
        }
    }
    //synchronized修饰静态⽅法
    public static synchronized void staticFunction() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            System.out.println("Static function running...");
        }
    }
    public static void main(String[] args){
        final SynchronizedDemo demo = new SynchronizedDemo();

        // 创建线程执⾏静态⽅法
        Thread t1 = new Thread(() -> {
            try {
                staticFunction();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        // 创建线程执⾏实例⽅法
        Thread t2 = new Thread(() -> {
            try {
                demo.function();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }
}
