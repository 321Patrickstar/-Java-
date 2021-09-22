package Thread;

/*
* 例子：创建三个窗口卖票，总票数为一百张
*这里要设置这个类的成员为static，还有其他方式
*1,问题：卖票的过程中，出现了重票，错票--》出出现了线程的安全问题
* 2,问题出现的原因：当某个线程操作车票的过程中，尚未操作完成时，其他线程参与进来也操作车票
* 3，如何解决：桑上厕所你得上完了出来再进来
* 当一个线程在操作共享数据的时候其他线程不能参与进来，直到线程a操作完共享数据时，其他线程才可以从操作
* 共享数据，即使线程a出现了阻塞，也不能改变
* 4再java中通过同步机制来解决线程安全问题
* 方式一：同步代码块
* synchronized（同步监视器）{
* 需要被同步的代码
*
* }
* 说明操作共享数据的代码即为需要被同步的代码
* 共享数据：多个线程共同操作的变量，比如tickets就是共享数据
* 同步监视器，俗称锁，任何一个类的都可以充当锁
* 要求我们多个线程必须要共用同一锁，这个锁多的话就没有意义了，必须是同一个
*
*
* 二：同步方法
*
*5 同步的方式，解决了线程的安全问题--好处
* 操作同步代码时只能有一个线程参与，其他线程等待，相当于是一个单线程的过程，效率低--局限性
*
* */
class Windows3 implements Runnable {
    private  int tickets = 100;
    final Object object  = new Object();
    @Override//操作咱们共享数据的
    //三个线程进去一个能执行
    public void run() {
        while (true) {
            synchronized (object) {//同步监视器
                if (tickets > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为" + tickets);
                    tickets--;
                } else {
                    break;
                }
            }
        }

    }
}
public class WindowsTestjava {
    public static void main(String[] args) {
        Windows3 wi = new Windows3();
        Thread t1 = new Thread(wi);
        Thread t3 = new Thread(wi);
        Thread t2 = new Thread(wi);
        t1.setName("窗口1");
        t1.setName("窗口2");
        t1.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();

    }

}
