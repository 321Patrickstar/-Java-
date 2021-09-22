package Thread;

import java.util.concurrent.locks.ReentrantLock;

/*
* 解决线程安全问题的方式三，lock锁----JDK5.0新增
* 面试题synchronized 和lock的异同
* 同步代码块和方法都是再在执行完相应的同步代码以后，自动的释放同步监视器
* lock需要手动的取启动同步（lock）方法同时结束同步也需要手动的实现（unlock（））才可以
* 面试题，如何解决线程的安全问题
*
*
* */
class Woindows2 implements Runnable{
private int tickets = 100;
private ReentrantLock lock = new ReentrantLock();//公平的true，三个线程依次，不公平iu是false每个都能抢
    @Override
    //1,先使用try方法将其包裹
    public void run() {
        while(true) {
            try {
                //带哦用一个锁定的方法try里面的是个单线程的
                lock.lock();
                if (tickets > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":售票，票号" + tickets);
                    tickets--;
                }

            } finally {
                lock.unlock();
            }
        }
    }
}
public class LockTest {
    public static void main(String[] args) {
        Window3 w = new Window3();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }



}
