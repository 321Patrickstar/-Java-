package javastudymiddle;

public class Student extends Person{
    String major;
    public Student(String name) {
        this.name = name;
    }
    public Student() {
    }
    public void study(){
        System.out.println("学习");
    }
    //对父类的方法重写
    public void eat(){
        System.out.println("吃饭多吃有营养的的食物");
    }
    public void eat(int amount){//子类也可以重载父类的方法，早绑定，静态绑定

    }

}
