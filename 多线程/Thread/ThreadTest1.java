package Thread;
/*
* 创建多线程的方式二，实现RUNnable的接口
* 1，创建一个实现了runnable接口的类
* 2.实现类去实现runanable中的抽样方法：run（）
* 3.创建实现类的对象
* 4.将此对象作为参数传递到thread类的构造器中，创建thread类的对象
* 5。通过thread类的对象调用start（）
*
*
* 比较创建线程的两种方式
* 开发中优先选择runnable接口的方式
* 原因1.实现的方式没有类的单继承的局限性
* 2.实现的方式更适合来处理多个线程，有共享数据的情况
*
*
* 联系 public class thread implements Runnable
* 两种方式都需要重写run（），将线程要执行的逻辑去声明再run（）中
*
*
* 并行多个人做不同的事情
* 并发多个人做同一个事 start两个作用先启动
*
*
* */
class MTthread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <100;i++){
            if(i%2==0){
                System.out.println(i);
                
            }
        }
    }
}
public class ThreadTest1 {
    public static void main(String[] args) {
        MTthread t1 = new MTthread();
        //就是thread的有参构造器转到runnable那个类里面去了
        Thread t2 = new Thread(t1);//多态//这个thread是runnable了
        t2.start();//t2的线程
       // new Thread(t1).start();//多态
        //再启动
        Thread t3 = new Thread(t1);
    }

}
