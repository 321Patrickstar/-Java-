package Generic;

import javaCollection.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 如何自定义泛型结构：泛型类、泛型接口；泛型方法。
 *
 * 1.关于自定义泛型类、泛型接口：
 *
 */

public class OrderTest {
    @Test
    public void test(){
        /**
         * 如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Object类型
         * 要求：如果大家定义了类是带泛型的，建议在实例化时要指明类的泛型。
         */
        Order order = new Order();
        order.setOrderT(123);
        order.setOrderT("ABC");

        //建议：实例化时指明类的泛型
        Order<String> order1 = new Order<String>("orderAA",1001,"order:AA");

        order1.setOrderT("AA:hello");
    }
    @Test
    public void test2(){
        Suborder suborder = new Suborder();
        //由于子类再继承带泛型的父类指明了泛型类型，不再需要指明泛型
        suborder.setOrderT(1234);
        Suborder1<String> suborder1 = new Suborder1<String>();
        suborder1.setOrderT("apple");
    }
    @Test
    public void test3() {
        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        //泛型不同的引用不能相互赋值。
        //list1 = list2;

        Person p1 = null;
        Person p2 = null;
        p1 = p2;
    }
    //测试泛型方法
    @Test
    public void test4() {
        Order<String> order = new Order<String>();
        Integer[] arr = new Integer[]{1,2,3,4};
        //泛型方法再调用时，指明泛型参数的类型
        List<Integer> copyfromarrlist = order.copyfromarrlist(arr);
        System.out.println(copyfromarrlist);
    }
}
