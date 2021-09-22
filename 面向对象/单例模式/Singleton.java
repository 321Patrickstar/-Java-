package javastudylast;
/*
* 只创建一个对象实例，所以构造器只能私有，在类内部创建对象，但是外部
* 无法访问到该对象，要用静态方法返回该对象
* 如何实现单例设计模式
* 懒汉式延迟对象创建线程不安全（冲突之后，会new两个）
* 饿汉式一开始就把对象创建好（会加载耗时）好处线程安全（同一个地址）
* */
public class Singleton {
    public static void main(String[] args) {
        Bank bank1 = Bank.getInstance();
        Bank bank2 = Bank.getInstance();
        System.out.println(bank1==bank2);
        //单例设计模式饿汉式
        //太饿了先造好了

    }
}
class Bank{

    //私有化类的构造器
    private Bank(){

    }
    //内部创建类的对象
    private static Bank instance = new Bank();
    //提供静态方法，返回类的对象
    public static Bank getInstance(){
        return instance;
    }
}
