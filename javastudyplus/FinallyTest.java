package javastudyplus;

import org.junit.jupiter.api.Test;

//一定会执行的，可选的
//finally声明的是一定会被执行的代码，即使catch中又出现异常了try中有return语句
//catch有return语句
/*
* 3.什么时候用到这个结构数据库连接输入输出流，网络的socket
* JVM是不能自动回收的，我们需要自己手动的进行资源的释放，此时的资源
* 释放就要声明在finally;
* try catch finally 结构可以嵌套
*
*
*
* */
public class FinallyTest {
    @Test
    public void test(){
        try {
            int a = 10;
            int b = 0;
            System.out.println(a/b);
        }catch (ArithmeticException e){
            int arr[] = new int[10];
            System.out.println(arr[10]);
        }catch (Exception e){
            e.printStackTrace();
        }
        //如果放在这里则一旦catch中出现异常则不会被执行直接抛出结构
        //如果finally有return语句也也许其他也有返回类型，也得等finally执行完的

        finally {
            System.out.println("好帅哦");
        }
    }
    @Test
    public void test2(){
        int a = 10;
        int b = 0;
        try {
            System.out.println(a/b);//找到错误点CTRL、alt，T
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
