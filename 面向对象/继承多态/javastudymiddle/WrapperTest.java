package javastudymiddle;
/*
* 包装类的使用
* 2.掌握的基本数据类型，包装类，string类三者相互转化
* 3.有的方法是object类的类型
* */

import org.junit.jupiter.api.Test;

import java.util.Scanner;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class WrapperTest {
    //基本数据类型如何————>包装类,调用包装类的构造器
    @Test
    void test1(){
        //涉及到从键盘输入值
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();
        Vector<Integer> v = new Vector<>();
        v.add(score);//这里的score是自动填装如果是5.0之前你得将他转成引用类型

        int num1 = 10;
        Integer in1 = 10;
        System.out.print(in1.toString());
        //如果是string类型的话里面得全是数字
        //否则会报异常
        //基本类型的默认值和类类型的默认值，一个是值一个是地址
        String str ="apple";//(这里应该神略了）
        String str2 = new String("apple");
        


    }
    //包装类变为基本数据类型
    @Test
    void test2(){
        Integer in2 = 12;
        int a = in2.intValue();
        System.out.println(a+1);
        //源码里面integercarch的缓存里面有个数组已经弄好了，就自己不用再new一个但如果超过127到-128的范围就得自己new一个了
        //主要目的，提高效率
        Integer in3 = a;//自动装箱不用去new一个了（不是new类型）
         method(in2);
        method(a);//并不是说把Object object = num1
        //自动拆箱
        int num4 = in3;
        //其他类似

    }
    public void method(Object object){

    }
    //基本类型和包装类如何转化为string类型
    //string类型转换为基本类型，包装类，调用包装类的paraseXxx()
    @Test
    void test3(){
        int num =10;
        //必须是纯数字或者数字字符串，如果里面带有其他字符报错
        //连接运算
        String str = num+"";
        float f1 = 12.3f;
        String str2=String.valueOf(f1);
        System.out.println(str2);
        Integer in4 = Integer.parseInt(str2);
        String str4 = "true1";
        boolean b1 = Boolean.parseBoolean(str4);
        //三目运算符要求两个结果都是同类型


    }

}