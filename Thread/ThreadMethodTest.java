package Thread;
/*
* 测试thread类中的常用方法
* start(),启动当前线程，调用当前线程的run（）方法
* run():需要重写thread中此方法，将创建执行的操作再此方法内
* 1.current thread():返回执行当前代码的线程
* 2.getname（）：获取当前线程的名字
* 3.setname():设置当前线程的名字
* 4.yield();释放当前cpu的执行权
* 5.join();在线程A中调用线程B的join()，线程A进入阻塞状态
* //只有B执行完以后结束阻塞状态
* 6 sleep（long milliontime）：让当前线程”sleep“让当前程序阻塞”milliontime，在指定的时间内，当前线程是阻塞状态（手动加塞）
* 7.isalive（）判断当前线程是否存活
* 8.MAX_PRIORITY//10
* MIN_PRIORITY1
* NORM_PRIORITY5
* 9.如何设置当前优先级
* getpriority（）
* setpriority（）
* 高优先级要抢占低优先级的执行权，只是一个概率性的去
* 不一定是高的执行完以后，低的才执行
* 优先级较高但是并不一定全都执行高优先级的
*
*
*
*
*
* */
class Thread4 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                //这是一个父类方法的异常throw在run方法内的话，必须父类的也throws，父类没有throws
                    //这是一个静态方法可以直接类来调用
                    //Thread.sleep(1000);//倒计时的时候阻塞一秒再等cpu分配资源
                System.out.println(Thread.currentThread().getName() + ":" +Thread.currentThread().getPriority()+ i);

                //这个是当前线程
            }
            if(i%20==0){
                this.yield();//这个是当前对象//释放当前的cpu执行
            }
        }
    }
    public Thread4(String name){
        super(name);//想使用父类的构造器来命名自己的线程
        //子类构造器一般都会调用父类构造器
    }
}
public class ThreadMethodTest {
    public static void main(String[] args) {
        Thread4 t1 = new Thread4("apple");
        //我想该线程的优先级

        t1.setName("线程一");

        //设置优先级
        t1.setPriority(8);

        t1.start();//要在start之前改名
        //主线程命名
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":"+Thread.currentThread().getPriority() + i);
            }//当前线程的
//            if (i == 20) {
//                try {
//                    t1.join();//就是一个线程执行执行到这个条件时候，另一个线程插了进来
//                    //等插进来的执行完以后，才能接着执行
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
            //System.out.println(t1.isAlive());//这坑定死了
        }
    }
}