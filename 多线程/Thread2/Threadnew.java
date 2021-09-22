package Thread2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
* 创建线程的方式三：实现callable接口----JDK 5.0新增
*1.提供一个实现callable接口的实现类
* 2。实现call方法，将此线程需要执行的操作声明再call方法中，需要返回值就写，没有就不写
* 3. 需要创建callable实现类对象
* 4.将callable实现类对象作为参数传递给futuretask构造器当中创造futuretask对象
* 5，将futuretask的对象作为参数传递到thread类的参数当中，创建thread的对象
* 6，thread的对象start
* 7.获取callable中call方法的返回值
*
*
*
*如何理解实现callable接口创建多线程实现比runnable接口创建多线程强大
* 1.call方法是有返回值的
* 2.call方法可以抛出异常，被外面的操作捕获，获取异常的信息
* 3.callable时支持泛型的
*
*
*
* */
class NumThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;//这里int转换为Integer
    }
}
public class Threadnew {
    public static void main(String[] args) {
        NumThread n1 = new NumThread();
        //FutureTask有泛型
        FutureTask<Integer> futureTask = new FutureTask(n1);
        Thread t1 = new Thread(futureTask);
        t1.start();
        try {
            //get方法的返回值即为futureTask构造器参数callable实现类的重写的call（）的返回值
            Object sum = futureTask.get();//这里才能换成integer
            System.out.println("总和为"+sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
