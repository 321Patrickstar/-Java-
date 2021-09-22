package Javastudylast2;
/*
* 抽象类的应用模板方法的设计模式
* 这里用到的其实是多态，因为父类是抽象类，而子类是实现类
* 我们要的是父类的对象去调用子类的重写的方法，就是子类变成父类就是多态向上转型
*
*
* */

public class TemplateTest {
    public static void main(String[] args) {
        Template t = new SubTemplates();//多态
        //Template t2 = new Template() ;//这里就报错了
        t.spendtime();//这是子类重写的方法，如果有好多子类就分别的去调用重写的方法
        //所以可以写一个模板类就像再写一个实现类就会好看些

    }
}
abstract class Template {
    //计算代码所花费的时间
    public void spendtime(){
        long start = System.currentTimeMillis();
        code();//不确定易变
        long end = System.currentTimeMillis();
        System.out.println("花费的实践为："+(end-start));
    }
    public abstract void code();
}
class SubTemplates extends Template{
    public void code() {
        for(int i =2;i<=1000;++i ){
            boolean isflag = true;
            for (int j  =2 ;j<=Math.sqrt(i);++j){
                if(i%j==0){
                    isflag =false;
                }
            }
            if(isflag){
                System.out.println(i);
            }
        }
    }
}