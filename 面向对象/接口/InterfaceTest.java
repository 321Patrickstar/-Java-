package javastudylast3;
/*
* 接口的使用
* 1.接口的使用interface来定义
* 2.java语言中，接口和类是并列的两个结构
* 3.如何定义接口，和类一样
* 4.在接口中定义成员
* 3.1接口 JDK七以前
* >全局常量 ，public static final的
* >抽象方法 ，public abstract的
*       JDK八的新特性定义全局常量和抽象方法之外
*       还可以定义静态方法,默认方法
* 4.1 接口中时不能调用构造器的，意味着接口不可以实例化
* 5.在开发中都是类来实现这接口 ，来实现（implements）的方式来使用
* 如果实现类重写（通常加覆盖了实现了）了所有接口里的所有抽象方法，此实现类就可以造对象了，否则任为抽象类
* 接口也可以继承
* 接口的应用(所有实现类要符合我们的接口，规范性）
* 6.Java来可以实现多个接口，弥补了单继承也可以多实现
* class AA extends BB implements CC,DD,EE(又继承，又实现）
* 接口和类关系是实现。类和类关系是继承
* 接口和接口是多继承，要是用类实现以下就要实现全部
* 接口使用要能实现多态性
* 接口的具体使用体现多态性
* 接口实际上看做是一种规范
* 抽象类和接口有哪些异同
* usb都有接口，电脑要实现接口来实现数据传输，实现类的集合（驱动）
* JDK 8 以上还可以可以调用静态方法，默认方法
* 面向接口编程（正针对JDBC中定义的接口
*
*
* */
public class InterfaceTest {
    public static void main(String[] args) {
        //静态方法类可以点获得
        System.out.println(FlyableInterface.mac_speed);
        //FlyableInterface.mind_speed = 2;final不能变
        FlyableInterface plane = new planet();
        plane.fly();
    }

}
interface Attack{
    //静态方法
    public static void method(){
        System.out.println("compareA北京");
    }
    void attack();
    //默认方法
    public default void method2(){
        System.out.println("compareA北京");
    }
}
interface FlyableInterface{
    //全局常量书写时可以省略，这三个关键字
    public static final int mac_speed = 7900;
    public static final int mind_speed =1;
    //抽象方法，省略了public abstract
    public abstract void fly();
}
class planet implements FlyableInterface{
    public void fly(){
        System.out.println("通过引擎起飞");

    }
}
class Kites implements FlyableInterface,Attack{

    @Override
    public void attack() {
        System.out.println("子弹可以伤人");
    }

    @Override
    public void fly() {
        System.out.println("子弹可以飞");
    }
}