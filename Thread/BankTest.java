package Thread;
/*
* 使用同步机制将这个单例模式的懒汉式改写为线程安全的
*
*
* */
public class BankTest {
}
class Bank {
    private Bank() {
    }

    private static Bank instance = null;//共享数据

    //public  static synchronized Bank getInstance(){//同步方法
    public static Bank getInstance() {//相当于线程
/*        //方式一，效率稍微差些//已经对象创建好了后面等的再判断
        synchronized (Bank.class) {
            if (instance == null) {
                instance = new Bank();//如果有两个线程，会造成创造两个对象
            }
        }
        return instance*/
        //我们得立个牌子，正名这里已经创建好了不用再在后面的等了
        if (instance == null) {//先判断再等，效率会高很多的
            synchronized (Bank.class) {
                instance = new Bank();//如果有两个线程，会造成创造两个对象
            }
        }
        return instance;
    }
}

