package javastudylast3;
/*
* 类的内部成员之五：内部类
* 1.将类A声明在另一个类B中，则类A是个内部类,类B外部类
* 2.内部类分类，成员内部类（静态，非静态）和局部内部类（方法内，构造器内，代码块内）
* 3.成员内部类
* 1.作为外部类的成员
* 调用外部类的属性persom.this.属性结构
* 可以static修饰
* 可以被四种不同的权限修饰
* 2.作为一个类
* 属性方法构造器等等
* 修饰final修饰（不被继承）不加可以继承abstract不饿能实例化
*
*不同名的话可以直接调用,如果重名的话怎么调用外部类结构
* 在开发中比较少
* 在方法种有返回类型，返回类型是个类，所以在方法中创建内部类来返回
* 例子中返回类型是接口，然后内部类返回对象
* 当然也可以return一个内部类匿名对象的匿名类没名字类
* 内部类
* 内部类都会生成字节码文件
* 局部内部类的生命周期，大括号内，不同作用区域，得到的方法也不同可以同名文件会自动区分
*
* */
public class IterClass {
    public static void main(String[] args) {
        Person.Liver liver = new Person.Liver();//
        Person p1 = new Person();
        Person.stomache stomache = p1.new stomache();
    }
}
class Person{
    String name;
    // 成员内部类(
    class stomache {

    }
    static class Liver {
    }
    public void method(){
        //局部内部类
        class AA{
            String name;
            public void method(String name){
                System.out.println(name);//方法属性
                System.out.println(this.name);//内部类属性
                System.out.println(Person.this.name);//外部类属性
            }

        }
    }
    {
        //局部内部类
        class BB{

        }
    }

    public Person() {
        //局部内部类
        class CC{

        }
    }
}
