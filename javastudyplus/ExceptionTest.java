package javastudyplus;

import org.junit.jupiter.api.Test;

/*
*一，
* 异常的体系结构
* java.lang.Throwable
* java.lang.Error;一般不编写针对性代码进行处理，一般叫做错误
* java.lang.Exception;可以进行异常的处理
* 一些常见的使用错误要认识
* checked(编译时异常）
* IOException
* ClassNotFoundException
* FileNotFoundException
* unchecked（运行时异常）
* NullPointerException
* ArrayIndexOutOfBoundsException
* ClassCastException
* InputMismatchException//例子
* ArithmeticException
* 异常处理，抓拍模型
* 过程一：“抛”，程序正在执行的过程中，一旦出现异常
* 就会在异常代码处生成一个对应异常类的对象
* 并将此对象抛出
* 一个抛出对象以后，其后的代码就不再执行
* 过程二：”抓“：异常的处理方式，1. try-catch-finally2throw
* 二try-catch-finally的使用
* try{
* 可能出现异常的代码
* }catch{异常类型1 变量名1}{
* 处理方式1
* }catch{异常类型2 变量名2}{
* 处理方式2
* }catch{异常类型3 变量名3}{
* 处理方式3
* }catch{异常类型4 变量名4}{
* 处理方式4
*}
* finally{
* //一定会执行的代码
* }
* 说明
* 1.finally时可选的
* 2.使用try将可能出现异常的代码封装起来，一旦出现异常，就会生成一个对应异常类的对象、
* 根据此对象的类型，在catch中进行匹配
* 3.一旦try中的异常对象匹配到某一个catch时，就进入catch中进行异常处理
* 一旦处理完成，跳出当前try catch结构（再没有写finally的情况），继续执行后面的代码
* 4.catch中的异常类型如果没有子父类关系，则谁声明在上，谁声明在下无所谓
*   catch中的异常类型如果满足子父类，则一定要声明在子类之后
* 5.常用的异常对象处理的方式1 String getMessage()//获取异常的信息
* printStacktrace（）
* 6.try结构中声明的变量，出了try结构以后不能在被调用（可以声明在外面）
* 体会try catch finally 处理编译的异常，程序在编译时不在报错，
* 但运行时可能报错，相当于我们使用这个结构将一个编译时的异常，延迟到运行时
*
*
*
*
* */
public class ExceptionTest {
    @Test
    public void test1(){
        String str = "123";
        str = "abe";
        try {
            int num = Integer.parseInt(str);//出现问题
        }catch(NumberFormatException e){//如果错误类型错了，错误会照常
            //System.out.println("出现数值转换异常了");//Exception这两个异常是两个子类
            //System.out.println(e.getMessage());//输出字符串内容调用函数
            e.printStackTrace();//两者是冲突的
        }catch (NullPointerException e){
            System.out.println("测试");
        }catch (Exception e){
            System.out.println("不要慌");
        }
        System.out.println("hello");
    }

}
