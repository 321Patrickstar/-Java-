package stringclass;

import org.junit.Test;
//方法区里面有的常量池
/*
*string 类的使用
* 表示字符串双引号表示
* final是不可继承的
* string 实现了serializable接口可序列化的，字符串支持序列化，通过流的方式传输对象就是可序列化
* comparable接口可以比较大小
* string内部定义了final char【】value可以用于存储字符串数据，底层是这样的
* string代表的是不可变的字符序列
* 赋值店铺是重新指定区域，而不是在原有的值改变
* string的值都在常量池中并且不重复，直接赋值变量地址为常量池中值的地址
* 而创建对象的初始化值现在常量池中找，找到存储的是常量池的地址，存储的属性的地址是对象的地址即堆地址
* 面试  String s2 = new String 创建了两个对象，一个是堆里的对象，一个是常量池中的char【】的数据
* 如果申明过得说明一下
* 常量和常量的拼接实在常量池，如果在变量名前加final
*
*
*
* */
public class StringTest {
    @Test
    public void test(){
        String s1 = "hellow";//字面量可以但不用创建对象是在字符串常量池
        //这里s2是在堆区域的是个引用类型变量存放地址调用的应该是常量池相同字符的地址
        //但是s1和s2也是不一样的存放类的地址的数据类的地址是堆的地址

        String s2 = new String("hellow");
        String s5 = new String("hellow");//这个实在堆区域
        //在堆区域的
        String s3 = "abc";
        s1 = "abc";//重新赋值算是
        //二者的地址值是一样的（都是在常量池中定义的，赋值的时候去常量池找，找到就不用创造，这个池子里面也不会有相同的值的
        s1 +="def";//这个也是不会接在后面都得新造一个内存区域连接操作时
        s1.replace('a','m');//把里面的字符替换都不行得重新造
        //都是char型数组

        System.out.println(s1==s2);

    }
    @Test
    public void test2(){
        String s1 = "1";
        String s2 = "2";//字面量
        String s3 = "1"+"2";//字面量的连接，在常量池中操作
        String s4 = s1+"2";//有变量参与的连接需要在堆空间创建，都是堆的地址值
        String s5 = "1"+s2;
        String s6 = s1 +s2;
        String s7 = "12";
        //之间的比较拼接是intern得从常量池去找
        String s8 = s4.intern();//这个函数的返回值就是在常量池里面的地址值了
        boolean b = (s8 == s3);

    }
}
