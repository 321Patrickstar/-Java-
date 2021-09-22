package javastudyplus;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/*
*”throws + 异常类型“写在方法的声明处，指此方法执行时，可能会抛出异常类型
* 一旦当方法体执行时出现异常，仍会在代码处生成一个异常类的对象
* 此对象满足throws异常类型时，就会被抛出，异常代码后续的代码就不再执行了
* 2.体会 try catch finally 真正的将异常给处理掉
*       throws的方式只是将异常抛给了方法的调用者，并没有将异常处理掉
* 关于throws子父类的异常问题见Java1
*
*
* 执行的方法中先后又调用了另外的几个方法，这几个方法是递进的关系，我们建议这几个方法
* 使用throws（的方式处理），而执行的方法可以使用try catch finally处理
*
* 关于异常的产生1.系统自己生成的异常对象
*            2.手动生成的一个异常对象，并抛出（throw）
*
*
*
*
* */

public class ExceptionTest2  {
    public static void main(String[] args) {
        try {
            method2();
        } catch (IOException e) {//抛到这里处理了
            e.printStackTrace();
        }

    }
    public static void method2() throws FileNotFoundException, IOException{
        method();//谁调用谁处理
    }
    public static void method() throws FileNotFoundException, IOException {
        File file = new File("helloworld");//错误抛给上面
        FileInputStream in = new FileInputStream(file);
        int data = in.read();
        while (data!=-1){
            System.out.println((char)data);
            data = in.read();
        }
        file.delete();
    }
}
