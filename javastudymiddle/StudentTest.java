package javastudymiddle;
import org.junit.jupiter.api.Test;
//单元测试类的要求（我么不想全部运行只测试一部分，用到了单元测试
//此类是public，此类提供公共的无参狗在其
//单元测试的方法，权限是public，额米有返回值，没有形参
//项目的增删改查，想要试试方法就用这个东西

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    int number;//这就是个普通方法，所以就相当于全局变量就不用再调对象了
    //测试和main函数的不同，main函数是static静态的函数
//声明好单元测试方法以后，就可以在方法体内测试相关的代码
    /*
    没有异常，绿条
    有异常，红条
    */
    @Test
    void study() {
        System.out.println("美眉");
    }

    @Test
    void eat() {

        number = 20;
        System.out.println(number);
        study();
    }
    @Test
    void testtostring(){

    }

    @Test
    void testEat() {
    }
}