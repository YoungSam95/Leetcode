package serialize;

public class MyThread implements Runnable{
    @Override
    public void run() {
        //打印当前线程名字
        System.out.println(Thread.currentThread().getName());
    }
    public static void main(String[] args){
        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(myThread,"线程1");
        Thread thread2 = new Thread(myThread,"线程2");
        thread2.setDaemon(true);
        thread1.start();
        thread2.start();
        System.out.println(Thread.currentThread().getName());
    }
}
