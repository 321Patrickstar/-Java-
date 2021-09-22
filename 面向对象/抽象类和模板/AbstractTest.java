package Javastudylast2;
/*
* abstract//当老板了此类不可实例化
* 但是有构造器，但是子类得调用所以还是需要的
* 开发中的子类的一般都要调用
* 抽象类中一定要有构造器
* 修饰类修饰方法,就是没有方法体，调用的话也没有意义
* 所以不能被调用，所以不饿能创造对象，所以得是抽象类
* 抽象方法一定得有抽象类，但抽象类可以没有抽象方法
* 子类想要调用抽象方法，要么子类重写抽象方法，要么子类变成抽象类
* 只有子类重写了之后，方可子类实例化，继承的理解
* 不仅是直接父类哪怕是间接父类，一旦子类继承都得实例化（重写方法）
* 关于抽象类的理解就是写个几何图形的类，计算面积体积，等等，但是不知道啥图形
* 我们可以写个抽象类，里面写个抽象求面积的方法，在子类中继承，并在子类中重写
* 这样只需要创建子类的实例就行了
* 交通工具类也是一样
* 抽象类的注意点不能修饰属性,构造器，代码块
* 不能用来修饰私有方法，私有方法是没法重写的，静态方法没法重写同名同参不叫覆盖
* final的方法也不行，final和abstract死对头
*  我说呢直接在调用对象的方法里面形参直接new 类型（）这是匿名对象
* 抽象类的匿名子类的对象
* 匿名子类的匿名对象
* person p = new person(){
* public void eat(){
* }
* }
*method（new person（）{public void eat(){
 * }}）
*
* */
public class AbstractTest {
    public static void main(String[] args) {
    }

}
abstract class Person {
    String name;
    int age;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //这是抽象方法只要有声明没有方法体;
    public abstract void eat();
}