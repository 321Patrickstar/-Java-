package javastudyone;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import static java.lang.System.*;//.*不就是全部么

/*
与C++的对比我们一般都将成员变量设置为私有，将成员函数设置为共有（其实C++也能这么做但不经常）
java把成员变量设置为共有就可以在，建立变量的时候就访问成员变量实现赋值，但是c++不能调用就需要用到构造函数
甚至对相同的变量的赋值会用到拷贝构造函数，而且java内没有对于指针的概念；
*/
//java 面向对象的学习
/*
java 学习的三条主线
1.java类以及类的成员，属性，构造器，方法，代码块，内部类；
2.java的三个特性，封装，继承，多态；
3.其他关键字 this ,super,static,final,abstract,interface,package,import
4,属性也就是成员的特性，就是成员变量，这个成员方法就是函数
5.成员变量是定义在类里面的，而局部变量是定义在方法里面的
6.局部变量是没有默认初始化的值。所以我们要显示赋值就是初始化
7.形参调用的时候赋值即可
8.成员变量调用是在堆内的，但是局部变量是在栈内的
math类 sqrt(),scanner
9.java的方法的声明：权限修饰符，返回值类型，方法名（形参）
方法体
10.对于没有返回类型的方法如果是使用return;则是表示结束此方法的意思
11.return的作用1，结束方法的2，对于有返回的类型的可以返回值
12.java的对象可以直接相等p3= p2;没有创建一个新的对象只是公用一个对象p3,p2对应在栈区域创建了个地址两个地址同时指向的堆空间的一处
13.万事万物皆是对象，设计到java语言与前端的，后端的数据库进行操作的时候就是类和对象
14.我们可以自己写一个工具类并且可以在本类去调用它，会使得代码变得简洁；就是分在不同的类文件内
15.重载函数名一样，但是参数类型不一样，参数列表不一样，参数个数不一样
16.可变个数形参的方法，参数类型...加参数名，字符串数组的定义与前面类似所以不能构成重载
17.声明一个新的变量放在栈区域，新的变量的地址指向堆区域，这是对象，对于基本的数据类型我们是直接存放在栈区域内的所以赋值赋的是真的值
18.而对于应用数据类型而言赋值复制的是地址
19。从这里又讲到了关于基本类型的交换方法，将实参传递给形参，基本类型的声明在栈区域存放的是值，且在方法中执行的时候也只是值交换
在方法结束之后，就被销毁了，但你实参的值并没有发生变化只不过是把值传递进去罢了，真正要做到交换你得把这两个的值的地址传递进去
20.我们得用引用数据类型（你得把他们封装到类里面，通过类来调用这两个值，就可以实现引用类型数据的传递（好麻烦）
21.我们使用基本数据类型的话放在栈区的是一个值
22.当我们要对这个类内的属性作限制的话，我们需要在类里面写方法（类似构造函数），当我们创建对象的时候
访问成员变量，也可以直接调用构造函数，来完成堆成员变量的初始化来避免这种情况的出现（leg = -4）
23.当我们把成员变量设置成私有的我们就只有通过接口（构造函数）这个方法来实现堆私有成员的访问
24.封装性的特性（1）对成员的私有，并通过公共方法来获取和设置私有的值，（2）方法变成私有，方法自己类使用
25.3.单例模式。。。，四种权限private（类内部） 缺省（同一包） protected（不同包，同一个子类） public（同一个工程）
26.四张权限可以修饰类方法属性构造器内部类，类只能缺兴，public
27.构造器的作用1.创建对象还可以初始化属性，如果没有显示定义的构造器的化则构造一个空参的构造器
28.定义构造器的格式，权限修饰符+类名（形参列表）{}，一旦我们自定义了构造器，系统就不再提供了
29.默认构造器的权限和类的权限一致，javabean 是一种 公共类，有一个公共无参构造器，有属性有getset的方法
30.关于this，理解就是当前对象，出现形参和属性重名的情况，后面让他表示形参，前面表示属性
31.在构造器中我们可以用this。调用当前对象的属性和方法，一般会省略，this 还可以修饰构造器，
在构造器中去调用其他的有参或者无参的构造器（但不能变成环）（来降低冗余）
32.PACKAGE为了更好实现项目类的管理，提出包的概念2，使用package来申明类或者接口使用的包，声明在源文件的首行
33.包都是小写的,每.都是一层文件目录，同一个包下不能定义同名的类和接口，不同的包下可以
34.import在源文件中导入指定包下的结构,声明在包和类之间，导入多个结构则并列写
35.lang包不用导本包定义的类和接口也不用
36.当我们要用不同包下的同名类我们需要在类名面前加包名（全类名）（两个的话只要一个就可）3个就两个
37.如果是使用包下的子包，还是得调用的，import static对应结构和属性，方法
*/
public class Person {
    public static void main(String[] arr){
        ArrayList an = new ArrayList();
        HashMap<String, String> arra = new HashMap<>();
        Scanner anner = new Scanner(System.in);
        //创建person的对象；实例化
        Person2 p1 = new Person2();
        //调用属性和方法
        p1.name = "tom";
        p1.age = 22;
        p1.ismale = true;
        p1.eat();//等等类似；
        Person2[] p4 = new Person2[5];//类对象数组
        new Person2().age =21;//匿名对象在开发的过程中可以直接使用匿名对象来进行参数传递
        Data da = new Data();
        da.m=20;
        da.n=10;
        Person p5 = new Person();
        p5.swap2(da);
        System.out.println(da.m);
        System.out.println(da.n);
        Person2 p = new Person2("tom");
        String info = Arrays.toString(new String[]{"1234"});//确实还要多看多练
        out.println();

    }
    public void swap2(@NotNull Data data){
        int temp1 = data.m;
        data.m = data.n;
        data.n = temp1;
    }
}
class Person2 {
    String name;
    int age;
    boolean ismale;
    public Person2(){
        System.out.println();
    }
    public Person2(String n ){
        this();
        name = n;
    }
    public Person2(String name,int age){
        this(name);
        this.age= age;
        this.name= name;
    }

    public void sleep( String name) {
        System.out.println("人可以睡觉");
    }

    public void eat() {
        System.out.println("人可以吃饭");
    }

    public void talk(){
        System.out.println("人可以走路");
    }
}
class Data{
    int m;
    int n;
}