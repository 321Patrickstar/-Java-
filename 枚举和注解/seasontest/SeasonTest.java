package seasontest;
/*
* 一，枚举类的使用
* 1.枚举类的理解：类的对象只有有限个，确定的，我们称此类为枚举类
* 2.当需要定义一组常量时，强烈建议使用枚举类
* 3.如果枚举类中只有一个对象，那么就可以当作单例模式的实现方式
*
*
* 二、如何定义枚举类
 *     方式一：JDK1.5之前需要自定义枚举类
 *     方式二：JDK 1.5 新增的enum 关键字用于定义枚举类
 *三，enum的常用方法
 * *      values()方法：返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举值。
 *      valueOf(String str)：可以把一个字符串转为对应的枚举类对象。要求字符串必须是枚举类对象的“名字”。如不是，会有运行时异常：IllegalArgumentException。
 *      toString()：返回当前枚举类对象常量的名称
 * * 使用enum关键字定义枚举类
 * 说明：定义的枚举类默认继承于java.lang.Enum类
 *
 * 四、使用enum关键字定义的枚举类实现接口的情况
 *   情况一：实现接口，在enum类中实现抽象方法
 *   情况二：让枚举类的对象分别实现接口中的抽象方法
 *
 *
* */
public class SeasonTest {
    public static void main(String[] args) {
        //创建类的对象调用静态对象
        Season spring = Season.Spring;
        System.out.println(spring);
        //values():返回所有的枚举类对象构成的数组
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
        Thread.State[] values1 = Thread.State.values();
        for (int i = 0; i < values1.length;i++){
            System.out.println(values1[i]);
        }
        //valueOf(String objName):返回枚举类中对象名是objName的对象。
        Season1 s = Season1.valueOf("Winter");
        //如果没有objName的枚举类对象，则抛异常：IllegalArgumentException
        //Season1 s = Season1.valueOf("Winter1");
        System.out.println(s);

    }
}
//定义枚举类
class Season{
    //声明season对象的属性:private final 修饰
    private final String seaonname;
    private final String seasonDesc;
    //1.私有化类的构造器
    private Season(String seaonname,String seasonDesc){
        this.seaonname = seaonname;
        this.seasonDesc = seasonDesc;
    }
    //3.提供当前枚举类的多个对象：public static final 的
    public static  final Season Spring = new Season(" 春天","春暖花开");
    public static  final Season Summer = new Season(" 夏天","春暖花开");
    public static  final Season Fall = new Season("秋天","春暖花开");
    public static  final Season Winnter = new Season(" 冬天","春暖花开");
    //4.其他的诉求：获取枚举类的对象的属性
    public String getSeaonname() {
        return seaonname;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
    //提供tostring的方法

    @Override
    public String toString() {
        return "Season{" +
                "seaonname='" + seaonname + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}