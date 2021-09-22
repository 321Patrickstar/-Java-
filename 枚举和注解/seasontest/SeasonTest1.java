package seasontest;

import javax.swing.*;

/*
*新增的enum 关键字用于定义枚举类
*
*
*
* */
public  class SeasonTest1 {
    public static void main(String[] args) {
        Season1 spring = Season1.Spring;
        System.out.println(spring);
        System.out.println(Season1.class.getSuperclass());
        spring.show();//对象的调用
        Season1[] values = Season1.values();
        for (Season1 value : values) {
            System.out.println(value);
            value.show();
        }

    }

}
//使用enum不能再使用public static findal 凡是长得一样的都删掉
//1.直接提供枚举类的对象，多个对象用，结尾;
enum Season1 implements Info{
   Spring(" 春天","春暖花开"){
       @Override
       public void show() {
           System.out.println("每人不一样1");
       }
   },
   Summer(" 夏天","春暖花开") {
       @Override
       public void show() {
           System.out.println("每人不一样2");
       }
   },
   Fall("秋天","春暖花开") {
       @Override
       public void show() {
           System.out.println("每人不一样3");
       }
   },
   Winter(" 冬天","春暖花开4") {
       @Override
       public void show() {
           System.out.println("每人不一样");
       }
   };
    private final String seaonname;
    private final String seasonDesc;
    //1.私有化类的构造器
    private Season1(String seaonname,String seasonDesc){
        this.seaonname = seaonname;
        this.seasonDesc = seasonDesc;
    }
    //3.提供当前枚举类的多个对象：public static final 的
    //4.其他的诉求：获取枚举类的对象的属性
    public String getSeaonname() {
        return seaonname;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }


    //如果想要每个对象调用show不一样可以
   /* @Override
    public void show() {
        System.out.println("这是一个抽样方法的实现");
    }*/
    //提供tostring的方法

   /* @Override
    public String toString() {
        return "Season{" +
                "seaonname='" + seaonname + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }*/
}
interface Info{
    void show();
}