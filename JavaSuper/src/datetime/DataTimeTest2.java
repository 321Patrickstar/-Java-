package datetime;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * jdk 8 之前的日期时间的API测试
 * 1.System类中currentTimeMillis();
 * 2.java.util.Date和字类java.sql.Date
 * 3.SimpleDateFormat
 * 4.Calendar
 */

/*
Calendar是一个抽象基类，主用用于完成日期字段之间相互操作的功能。
        获取Calendar实例的方法
        使用Calendar.getInstance()方法
        调用它的子类GregorianCalendar的构造器。
        一个Calendar的实例是系统时间的抽象表示，通过get(intfield)方法来取得想要的时间信息。比如YEAR、MONTH、DAY_OF_WEEK、HOUR_OF_DAY 、MINUTE、SECOND
public void set(intfield,intvalue)
public void add(intfield,intamount)
public final Date getTime()
public final void setTime(Date date)
        注意:
        获取月份时：一月是0，二月是1，以此类推，12月是11
        获取星期时：周日是1，周二是2，。。。。周六是7
*/


public class DataTimeTest2 {
    @Test
    public void testCalendar() {

        //1.实例化
        //方式一：创建其子类（GregorianCalendar）的对象
        //方式二：调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();

//        System.out.println(calendar.getClass());    //class java.util.GregorianCalendar

        //2.常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);   //10
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR)); //131,今天是这一年的131天

        //set()
        //calendar可变性
        calendar.set(Calendar.DAY_OF_MONTH, 22);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);   //22

        //add()
        calendar.add(Calendar.DAY_OF_MONTH, -3);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);   //22-3 --》19

        //getTime():日历类---> Date
        Date date4 = calendar.getTime();
        System.out.println(date4);   //Tue May 19 17:12:06 CST 2020

        //setTime():Date ---> 日历类
        Date date3 = new Date();
        calendar.setTime(date3);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);//10
    }
    //这个类存在的问题
 /*   可变性：像日期和时间这样的类应该是不可变的。
    偏移性：Date中的年份是从1900开始的，而月份都从0开始。
    格式化：格式化只对Date有用，Calendar则不行。
    此外，它们也不是线程安全的；不能处理闰秒等。*/
    @Test
    public void test2(){
        //偏移量
        Date date1 = new Date(2020,9,8);
        System.out.println(date1);  //Fri Oct 08 00:00:00 CST 3920

        Date date2 = new Date(2020 - 1900,9 - 1,8);
        System.out.println(date2); //Tue Sep 08 00:00:00 CST 2020
    }
}
