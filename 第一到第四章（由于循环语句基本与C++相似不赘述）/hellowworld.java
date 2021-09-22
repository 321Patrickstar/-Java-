package javastudyone;
import java.util.ArrayList;
import java.util.Scanner;
//标识符数字不能在第一，标识符内不能有空格，标识符不能时关键词
//编码规范，严格区分大小写；
//alt+r快捷键执行
//包名多个单词组成都必须是小写xxxyyy
//类名，接口名，多个单词组成时单词的首字母大写XxxYyy(大驼峰）
//变量名，方法名，多个单词组成时第一个单词小的
//常量名都全部大写
//多了三个引用数据类型（类（class），接口（interface),数组（array）
//变量；类型布尔类型变成booleaen
//自动类型提升和自动类型的强制转换
//btye类型和int类型byte小int大byte+int会被转化位int类型
//byte char short 三种类型作运算的时候为int类型
//强制类型转换有强制转换符 double i = 0 ; int  a = (int)i;
//强制转换要注意精度损失；
//在使用long类型后面有个L会提升容量如果不是l就默认int转换为long但数值不能超过int否则报错
//float类型则必须要在后面加f；
//整形常量默认为int类型，浮点常量类型默认为fouble所以在加入常量的时候要注意
//字符串类型可以为空，但是字符类型不能为空
//string类型运算与八种基本类型运算，但是运算只能作+运算连接运算
//与char类型的+要看是和string还是其他类型，其他类型就是int 类型的+返回的是ascll码值
//string类型就是字符串
///是除%取余运算+=2就是自身加2（不会改变本身的数据类型
//比较还是原样但是逻辑运算符不一样了
//ab为bool类型
//&和&&的区别
//相同点结果都是一样的但是如果左边是false，单个会在执行右边，双个一个false就不会考虑右边了
//|和||也是一样的如果一个是当符号左边是true，单个会在执行右边，双个就不会考虑右边了
//位运算符>>1;都是换算成二进制的
//<<在一定范围内向左移动一位相当于乘2
//>>在一定范围内向右移动一位相当于除2
//位运算的&|~都是换算成二进制之后0为f1为true然后进行逻辑运算返回数值
//三元运算符（条件表达式）？表达式1：表达式2；三元运算符是可以嵌套使用的，条件和语句都是可以嵌套的
//流程语句
//如何取获得从键盘获取不同类型的变量，需要用一个scanner类
//1.导包
//基本的格式 import java.util.Scanner
//调用scanner类的相关方法（函数）
//除了string类型是next(),其他类型都是next+类型（）；
//复习switch(表达式){
//case 变量1：
//执行语句；
//break;
//等等
//

public class hellowworld {
    public static void main(String[] arry){
        Scanner scan = new Scanner(System.in);//scanner类的一个实例化
        int num = scan.nextInt();//这里就相当于cin>>；
        String str = scan.nextLine();
        System.out.println(num);
        float a = 2.0f;
        a +=2;
        int w = 1;
        w*=0.1;
        System.out.println(w);
        System.out.println(a);
        System.out.println("hellowworld");
        ArrayList list = new ArrayList<String>();
        String we = "hellpw";
        char grand = we.charAt(2);
        System.out.println(grand);
        //1静态初始化；
        int [] ids = new int[]{1001,1002,1003,1004};
        //2动态初始化
        String [] names = new String[6];
        //一样的下标赋值
        names[1] = "apple";
        System.out.println(names.length);//可以直接获取数组的长度
        //数组的默认初始化值,是整型的都是0浮点0.0，char类型不是'0'，布尔类型就是false，string就是“null”
        //二维数组的声明和初始化
        //静态初始化
        int[][] arr = new int[][]{{123},{1235},{12}};//这里的行其实是个地址值，地址存放在栈区域，而对应元素存放在
        //堆区域
        //动态初始化
        int[][] arr2 = new int[3][2];//一个三行二列的数组
        //调用二维数组指定位置上的元素
        System.out.println(arr[0][0]);//第一行第一个元素
        //获取数组的长度
        System.out.println(arr.length);//里面有三个元素，且都是数组
        System.out.println(arr[0].length);//元素的元素；
        System.out.println();
        System.out.println(123);
        System.out.printf("");
        //souf sout;
        //遍历一个二维数组
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.println(anInt);
            }
        }
        //数组的地址都是地址，new全部都是放在堆空间里面的

    }
    public void method1(){
    }
}

