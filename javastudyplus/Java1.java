package javastudyplus;

import java.io.IOException;

/*
* 方法重写的规则
* 子类重写的抛出的异常类型不能大于父类抛出的异常类型
* 父类没有抛异常，子类也绝对不能抛，因为他就是子父类的关系啊
*
* */
public class Java1 {
    public static void main(String[] args) {
        Java1 test = new Java1();
        SuperClass a = new Subclass();//多态性调重写的方法
        test.display(a);
    }
    public void display( SuperClass e){
        try {
            e.method();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
class SuperClass {
    public void method() throws IOException {
    }
}
class Subclass extends SuperClass {
    public void method() throws IOException {//没有也行但不能比父类大

    }

}
