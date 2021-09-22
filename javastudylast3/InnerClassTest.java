package javastudylast3;
/*
* 在局部内部类的方法（show）中想要调用局部内部类所在的声明的方法（method）中的局部变量的话
* 要求此局部变量是final（number）因为两个类文件
* 外部类文件内的数据传过来是副本，不能被改变
* JDK7以前显示JDK8以后隐式的
* 匿名的局部内部类对象（这里没弄懂，主要是匿名的问题也不太弄懂）
*
* */

public class InnerClassTest {
    public void method(){
        int number =10;
        class AA{
            public void show(){

            }
        }
    }
}
