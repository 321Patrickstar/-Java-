package Thread2;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/*
* 创建线程的方式：使用线程池
*1.提高了响应速度
* 2.降低了资源消耗
* 3.便于线程管理
*
*
*
* */
 class NumberThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <100;++i){
            if(i%2==0){
                System.out.println(i);
            }
        }
    }
}
class NumberThread1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <100;++i){
            if(i%2==1){
                System.out.println(i);
            }
        }
    }
}
public class ThreadPool {
    public static void main(String[] args) {
        //1提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        //这个接口属性少又没类，我们实际调用应该去找对应的实现类
        //设置线程池属性
        System.out.println(service.getClass());//找到实现类
        ThreadPoolExecutor service1 = ( ThreadPoolExecutor) service;
        service1.setCorePoolSize(15);//核心大小
        //service1.setKeepAliveTime();线程没有任务最多保持多长时间停止
        service1.setMaximumPoolSize(16);//最大线程数
        //创建线程的四种方式






        //2执行指定线程的操作，需要提供实现runnable接口或者callable接口实现类的对象
        //service.submit(Callable callable);//适合使用于callable
        service.execute(new NumberThread());//适合于runnable
        service.execute(new NumberThread1());
        //关闭线程池
        service.shutdownNow();
    }

}
