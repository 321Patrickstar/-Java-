package Generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义泛型类
 *
 */
//异常类不能声明为泛型类
//public class MyException<T> extends Exception{
//}
public class Order<T> {
    String orderName;
    int orderId;
    //类的内部结构就可以使用类的泛型
    T orderT;//这算是个参数（可以当作类来看,当作是个变量，一个类型）
    public Order(){
        //编译不通过
        //T[] arr = new T[10];
        T[] arr = (T[]) new Object[10];

    };
    public Order(String orderName,int orderId,T orderT){
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    //如下的三个方法都不是泛型方法
    public T getOrderT(){
        return orderT;
    }
    //调用方法时就可以自定义类型了
    public void setOrderT(T orderT){
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }
    //静态方法不能使用泛型类，因为对象创建再静态方法之后不能确定类型
    public void show(){
        //编译不通过
//        try{
//
//
//        }catch(T t){
//
//        }
    }
    //泛型方法：在方法中出现了泛型的结构。泛型参数与类的泛型参数没有任何关系
    //换句话说，泛型方法所属的类不是泛型类都没有关系
    //泛型方法，可以声明为静态的，原因：泛型参数实在调用方法是确定的，并非是再实例化确定的
    public static  <E> List<E> copyfromarrlist(E[] arr){
        ArrayList<E> result = new ArrayList<>();
        for (E e : arr){
            result.add(e);
        }
        return result;
    }

}
