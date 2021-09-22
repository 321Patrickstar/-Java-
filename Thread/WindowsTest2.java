package Thread;
/*
* 出现错票重票的问题
* 多个线程去做同一件事
* 使用同步代码块的方法来解决继承的安全问题
* 使用同步方法来处理继承Thread类的方式中的线程安全问题
* 同步方法任然涉及到同步监视器，只是我们不需要显示的声明
* 2.非静态的同步方法，同步监视器是this（是不是唯一）
* 静态的同步方法，同步监视器是类本身（是不是唯一）
*
*
* */
class Window3 extends Thread{
    private static int ticket = 100;
    @Override
    public void run() {
        show();
    }
    //仿照实现的方式在这加同步
    public static synchronized void show(){//,我们想要就用一个静态的坑定不是对象，是唯一的，所以是一把锁
        //public  synchronized void show()//同步监视器t1,t2,t3
        while (true) {
            if (ticket > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "卖票，票号为" + ticket);
                ticket--;
            } else {
                break;
            }
        }
    }
}
public class WindowsTest2 {
    public static void main(String[] args) {
        Window3 w1 = new Window3();//在这里问题，每个新建的对象都会有自己的100
        Window3 w2 = new Window3();//存在线程安全问题，后面解决
        Window3 w3 = new Window3();
        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");
        w1.start();
        w2.start();
        w3.start();
    }
}