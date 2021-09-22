package Thread;

import java.util.function.DoubleFunction;

/*
* 多线程的创建，方式一；继承于thread
* 1.我们需要创建一个继承于thread的子类
* 2.重写thread类的run（）--->此线程执行的操作声明在run（）中
* 3.创建thread子类对象
* 4.通过此对象调用start（）
* 例子编译100以内的偶数
* @outhor shkstart
* @create
*
*
* */
//创建一个继承于thread的子类
class MyThread extends Thread {
    //重写thread类的run（）
    @Override
    public void run() {
        for(int i =0;i<100;++i){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+"；"+ i);
            }
        }

    }
}
public class ThreadTest {
    public static void main(String[] args) {
        //创建thread子类对象
        MyThread myThread = new MyThread();//alt +enter直接生成下次直接new就可以了
        myThread.start();//调用完start以后分线程开始执行了      对象和调用时是主线程
        //我们不能通过直接调用run（）的方式自动线程
        //myThread.run();
        //问题二，再启动一个线程，遍历100以内的偶数
        //不可以已经start的线程去start一个新的线程
        //需要重新创建一个线程的对象来开启一个新的线程
        MyThread myThread1 = new MyThread();
        myThread1.start();
        System.out.printf("hellow");//发现hellow在前面
        //说具有交互性，但其实自己电脑太强了都给他理清了
        //这些还是在main线程做的
        for(int i =0;i<100;++i){
            if(i%2==0){
                System.out.println(i+"主");
            }
            //大于两个线程就能看到交互性质了
        }

    }
}
