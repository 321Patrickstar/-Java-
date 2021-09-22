package Thread;
/*
* 创建两个分线程，其中一个100偶数，另一个100奇数
*
*
* */
class MyThread1 extends Thread{
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
class MyThread2 extends Thread{
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2==1){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }

        }
    }
}
public class ThreadDemo {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        MyThread2 t2 = new MyThread2();
        t1.start();
        t2.start();
        //创建thread类的匿名子类（就是用一次没必要创建类的情况）
        new Thread(){
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();
    }
}
