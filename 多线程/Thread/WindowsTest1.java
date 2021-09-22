package Thread;
/*
* 例子：创建三个窗口卖票，总票数为一百张
*
*
* */
public class WindowsTest1 {
    public void main(String[] args) {
        Windows1 w1 = new Windows1();
        //三个线程使用同一个window，就不用加static了
        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);
        //默认的是公用同一个对象
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

    }
}
class Windows1 extends Thread{
    private static int tickets = 100;

    @Override
    public void run() {
        while (true) {
            if (tickets > 0) {
                System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + tickets);
                tickets--;
            } else {
                break;
            }
        }
    }
}