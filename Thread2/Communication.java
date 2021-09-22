package Thread2;
/*
* 线程通信的例子：使用两个线程打印1-100，线程一，线程二交替打印
* 涉及到的三个方法
* wait()一旦执行此方法当前线程进入阻塞状态并释放同步监视器
* notify()一旦执行此方法，就会唤醒被wait的一个线程，如果有多个线程wait，就唤醒优先级高的那个
* notifyall 一旦执行次方法，就会唤醒所有被wait的线程
*
*
* 注意点
* 1.线程通信的三个方法必须使用在同步代码快或者方法中
* 2.这三个方法的调用者必须是同步代码块或者是同步方法中的同步监视器，否则会出现异常
* 3.这三个方法时定义再Java。lang。object。
* 4.因为同步监视器时任何类的对象，任何对象调用方法
*
*
* sleep()和wait（）方法的异同
* 1.相同，执行方法都可以让当前线程进入阻塞状态
* 2.不同点：1）两个方法声明的位置不同，Thread类中声明sleep（），object类中声明wait（）
*         2）调用的范围要求不同，sleep（）可以在任何需要的场景下带哦用wait（）同步代码块或者是同步方法
*         3）关于是否释放同步监视器的问题，如果两个方法都使用在同步代码快或同步方法中，sleep（）不会释放锁，wait（）会被释放
*
* */
class Number implements Runnable{

private int number = 1;
    @Override
    public void run() {
        while(true){
            synchronized (this) {//线程一进来，堵塞，线程而进来唤醒线程一，但是，线程二手里拿着锁呢，所以线程二执行
                notify();//唤醒一个还是唤醒多个notifyall（）
                if(number<100){
                    System.out.println(Thread.currentThread().getName()+":"+number);
                    number++;//
                    try {
                        //使得带哦用如下wait（）方法的线程进入阻塞状态
                        wait();//一旦执行就会释放锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    break;
                }
            }
        }

    }
}
public class Communication {
    public static void main(String[] args) {
        Number num = new Number();
        Thread t1 = new Thread(num);
        Thread t2 = new Thread(num);
        //Thread t3 = new Thread(num);
        t1.setName("线程1");
        t2.setName("线程2");
       // t3.setName("线程3");
        t1.start();
        t2.start();
        //t3.start();


    }
}
